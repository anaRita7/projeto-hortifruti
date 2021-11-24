package com.br.backendhortifruti.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Integer id;

	@Column(name = "codigo")
	private Integer codigo;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "unidade_medida")
	private String unidadeMedida;

	@Column(name = "valor_unitario")
	private double valorUnitario;

	@Column(name = "status")
	private boolean status;

	@Column(name = "imagem")
	private String imagem;

}
