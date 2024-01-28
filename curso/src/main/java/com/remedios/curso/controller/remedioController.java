package com.remedios.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedios.curso.remedio.DadosCadastroRemedio;
import com.remedios.curso.remedio.RemedioRepository;
import com.remedios.curso.remedio.Remedios;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/remedios")
public class remedioController {

    @Autowired
    private  RemedioRepository repository;
    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroRemedio dados) {
        repository.save(new Remedios(dados));
    }
}
