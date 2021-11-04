package com.br.backendhortifruti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int codigo;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "unidade_medida")
	private String unidadeMedida;
		
	@Column(name = "valor_unitario")
	private float valorUnitario;
		
	@Column(name = "status")
	private boolean ativo;
	
	public Produto() {}

	public Produto(int codigo, String descricao, String unidadeMedida, float valorUnitario, boolean ativo) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.unidadeMedida = unidadeMedida;
		this.valorUnitario = valorUnitario;
		this.ativo = ativo;
	}

	public Produto(String descricao, String unidadeMedida, float valorUnitario, boolean ativo) {
		this.descricao = descricao;
		this.unidadeMedida = unidadeMedida;
		this.valorUnitario = valorUnitario;
		this.ativo = ativo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public float getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
