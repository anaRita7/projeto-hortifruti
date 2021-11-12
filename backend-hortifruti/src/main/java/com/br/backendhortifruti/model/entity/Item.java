package com.br.backendhortifruti.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.br.backendhortifruti.model.dto.ProdutoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "item_do_pedido")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_do_pedido")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	@JsonIgnore
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;
		
	@Column(name = "quantidade")
	private Integer quantidadeTotal;
		
	@Column(name = "valor_total")
	private float valorTotal;

 	public ProdutoDTO getProdutoDTO(){ return ProdutoDTO.converter(getProduto()); }
}
