package com.remedios.curso.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedios.curso.remedio.DadosCadastroRemedio;

@RestController
@RequestMapping("/remedios")
public class remedioController {
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroRemedio json) {
        System.out.println(json);
    }
}
