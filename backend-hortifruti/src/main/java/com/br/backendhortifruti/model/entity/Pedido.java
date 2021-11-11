package com.br.backendhortifruti.model.entity;

import com.br.backendhortifruti.model.dto.ClienteDTO;
import com.br.backendhortifruti.model.dto.EnderecoDTO;
import com.br.backendhortifruti.model.dto.ItemDTO;

import java.time.LocalDate;
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

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Integer id;
	
	@Column(name = "codigo")
	private Integer codigo;
	
	@Column(name = "data")
	private LocalDate data;
	
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
	
	@OneToMany(mappedBy = "pedido")
	private List<Item> itens;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public ClienteDTO getClienteDTO() { return ClienteDTO.converter(getCliente());}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public EnderecoDTO getEnderecoDTO(){ return EnderecoDTO.converter(getEndereco());}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public boolean isSituacao() {
		return situacao;
	}

	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getQuantidadeTotal() {
		return quantidadeTotal;
	}

	public void setQuantidadeTotal(Integer quantidadeTotal) {
		this.quantidadeTotal = quantidadeTotal;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public List<Item> getItens() {
		return itens;
	}

	public List<ItemDTO> getItensDTO(){ return ItemDTO.converterLista(getItens()); }

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

}
