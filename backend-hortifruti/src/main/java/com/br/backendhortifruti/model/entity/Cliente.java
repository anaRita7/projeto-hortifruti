package com.br.backendhortifruti.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "tipo")
	private char tipo;

	@Column(name = "documento")
	private String documento;

	@Column(name = "telefone")
	private String telefone;

	public Cliente(Integer id, String nome, char tipo, String documento, String telefone) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.documento = documento;
		this.telefone = telefone;
	}
}
