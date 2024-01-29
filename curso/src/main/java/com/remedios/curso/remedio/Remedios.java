package com.remedios.curso.remedio;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "remedios")
@Entity(name = "remedios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedios {
    public Remedios (DadosCadastroRemedio dados) {
        this.nome=dados.nome();
        this.via=dados.via();
        this.lote=dados.lote();
        this.quantidade=dados.quantidade();
        this.validade=dados.validade();
        this.laboratorio=dados.laboratorio();
        this.ativo = true;
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private via via;
    private String lote;
    private int quantidade;
    private  LocalDate validade;

    @Enumerated(EnumType.STRING)
    private  laboratorio laboratorio;

    private boolean ativo;

    public void atuaInformacoes(@Valid DadoaAtualizarRemedio dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.via() != null) {
            this.via = dados.via();
        }
        if (dados.laboratorio() != null) {
            this.laboratorio = dados.laboratorio();
        }
    }

    public void inativar() {
        this.ativo = false;
    }
}
