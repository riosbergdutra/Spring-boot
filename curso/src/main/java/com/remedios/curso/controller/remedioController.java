package com.remedios.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.remedios.curso.remedio.DadoaAtualizarRemedio;
import com.remedios.curso.remedio.DadosCadastroRemedio;
import com.remedios.curso.remedio.DadosDetalhamentoRemedio;
import com.remedios.curso.remedio.DadosListagemRemedio;
import com.remedios.curso.remedio.RemedioRepository;
import com.remedios.curso.remedio.Remedios;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.var;

@RestController
@RequestMapping("/remedios")
public class remedioController {

    @Autowired
    private  RemedioRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> cadastrar(@RequestBody @Valid DadosCadastroRemedio dados,UriComponentsBuilder builder) {
        var remedio = new Remedios(dados);
        repository.save(remedio);   
        var uri = builder.path("/remedios/{id}").buildAndExpand(remedio.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoRemedio(remedio));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemRemedio>> listar(){
        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemRemedio::new).toList();
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> atualizar(@RequestBody @Valid DadoaAtualizarRemedio dados) {
        var remedio = repository.getReferenceById(dados.id());
        remedio.atuaInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));  
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        remedio.inativar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("reativar/{id}")
    @Transactional
    public ResponseEntity<Void> reativar(@PathVariable Long id) {
        var remedio = repository.getReferenceById(id);
        remedio.reativar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> detalhar(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
    }
}
