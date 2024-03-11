package com.estudo.estudo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@EqualsAndHashCode(of = "id_usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id_usuario;

@Column(nullable = false)
private String nome;

@Column(nullable = false, unique = true)
private String email;

@Column(nullable = false)
private String senha;

private Double quantia_dinheiro;
}
