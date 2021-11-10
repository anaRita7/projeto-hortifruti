package com.br.backendhortifruti.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	public Cliente() {
	}

	public Cliente(Integer id, String nome, char tipo, String documento) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.documento = documento;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

}
