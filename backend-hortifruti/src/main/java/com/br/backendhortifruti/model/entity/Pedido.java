package com.br.backendhortifruti.model.entity;

import com.br.backendhortifruti.model.dto.ClienteDTO;
import com.br.backendhortifruti.model.dto.EnderecoDTO;
import com.br.backendhortifruti.model.dto.ItemDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Integer id;
	
	@Column(name = "codigo")
	private Integer codigo;
	
	@Column(name = "data_hora")
	private LocalDateTime dataHora;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	
	@Column(name = "situacao")
	private boolean situacao;
	
	@Column(name = "valor_total")
	private Double valorTotal;
	
	@Column(name = "quantidade_total")
	private Integer quantidadeTotal;
	
	@Column(name = "desconto")
	private Double desconto;
	
	@Column(name = "valor_final")
	private Double valorFinal;

	@Column(name = "forma_pagamento")
	private String formaPagamento;
	
	@OneToMany(mappedBy = "pedido")
	private List<Item> itens;

	public ClienteDTO getClienteDTO() { return ClienteDTO.converter(getCliente());}

	public EnderecoDTO getEnderecoDTO(){ return EnderecoDTO.converter(getEndereco());}

	public List<ItemDTO> getItensDTO(){ return ItemDTO.converterLista(getItens()); }
}
