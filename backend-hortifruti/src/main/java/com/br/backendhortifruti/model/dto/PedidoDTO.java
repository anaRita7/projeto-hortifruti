package com.br.backendhortifruti.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.br.backendhortifruti.model.entity.Cliente;
import com.br.backendhortifruti.model.entity.Endereco;
import com.br.backendhortifruti.model.entity.Pedido;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
public class PedidoDTO {

	private Integer id;
    private Integer codigo;
    @JsonFormat(pattern="dd/MM/yyyy HH:mm:ss") 
    private LocalDateTime dataHora;
    private Cliente cliente;
    private Endereco endereco;
    private boolean situacao;
    private Double valorTotal;
    private Integer quantidadeTotal;
    private Double desconto;
    private Double valorFinal;
    private String formaPagamento;
    private List<ItemDTO> itens;

    public PedidoDTO(Pedido pedido){
    	this.id = pedido.getId();
        this.codigo = pedido.getCodigo();
        this.dataHora = pedido.getDataHora();
        this.cliente = pedido.getCliente();
        this.endereco = pedido.getEndereco();
        this.situacao = pedido.isSituacao();
        this.valorTotal = pedido.getValorTotal();
        this.quantidadeTotal = pedido.getQuantidadeTotal();
        this.desconto = pedido.getDesconto();
        this.valorFinal = pedido.getValorFinal();
        this.formaPagamento = pedido.getFormaPagamento();
        this.itens = pedido.getItensDTO();
    }

    public static List<PedidoDTO> converterLista(List<Pedido> pedidos) {
        return pedidos.stream().map(PedidoDTO::new).collect(Collectors.toList());
    }

    public static PedidoDTO converter(Pedido pedido){
        return new PedidoDTO(pedido);
    }
}
