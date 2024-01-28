package com.remedios.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedios.curso.remedio.DadoaAtualizarRemedio;
import com.remedios.curso.remedio.DadosCadastroRemedio;
import com.remedios.curso.remedio.DadosListagemRemedio;
import com.remedios.curso.remedio.RemedioRepository;
import com.remedios.curso.remedio.Remedios;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/remedios")
public class remedioController {

    @Autowired
    private  RemedioRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroRemedio dados) {
        repository.save(new Remedios(dados));
    }

    @GetMapping
    public List<DadosListagemRemedio> listar(){
        return repository.findAll().stream().map(DadosListagemRemedio::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadoaAtualizarRemedio dados) {
        var remedio = repository.getReferenceById(dados.id());
        remedio.atuaInformacoes(dados);
    }
}
