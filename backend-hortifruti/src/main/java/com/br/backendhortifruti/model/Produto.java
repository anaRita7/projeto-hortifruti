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
	private int id;
	
	@Column(name = "codigo")
	private int codigo;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "und_medida")
	private String unidadeMedida;
		
	@Column(name = "valor")
	private float valorUnitario;
		
	@Column(name = "status")
	private boolean status;
	
	public Produto() {}
	
	public Produto(int codigo, String descricao, String unidadeMedida, float valorUnitario, boolean status) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.unidadeMedida = unidadeMedida;
		this.valorUnitario = valorUnitario;
		this.status = status;
	}

	public Produto(int id, int codigo, String descricao, String unidadeMedida, float valorUnitario, boolean status) {
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
		this.unidadeMedida = unidadeMedida;
		this.valorUnitario = valorUnitario;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}	
}
