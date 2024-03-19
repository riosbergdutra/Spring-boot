package test.event.eventdriven.entrega.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import test.event.eventdriven.entrega.enums.StatusPedido;

@Entity
@Table(name = "entrega")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_entrega;
    private Long id_pagamento;
    private String endereco;
    @Enumerated(EnumType.STRING)
    private StatusPedido StatusPedido;

}
