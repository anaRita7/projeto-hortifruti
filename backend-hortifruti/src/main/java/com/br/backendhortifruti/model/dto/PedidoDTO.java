package com.br.backendhortifruti.model.dto;

import com.br.backendhortifruti.model.entity.Pedido;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PedidoDTO {

    private Integer codigo;
    private LocalDate data;
    private ClienteDTO cliente;
    private EnderecoDTO endereco;
    private boolean situacao;
    private Double valorTotal;
    private Integer quantidadeTotal;
    private Double desconto;
    private Double valorFinal;
    private List<ItemDTO> itens;

    public PedidoDTO(Pedido pedido){
        this.codigo = pedido.getCodigo();
        this.data = pedido.getData();
        this.cliente = pedido.getClienteDTO();
        this.endereco = pedido.getEnderecoDTO();
        this.situacao = pedido.isSituacao();
        this.valorTotal = pedido.getValorTotal();
        this.quantidadeTotal = pedido.getQuantidadeTotal();
        this.desconto = pedido.getDesconto();
        this.valorFinal = pedido.getValorFinal();
        this.itens = pedido.getItensDTO();
    }

    public static List<PedidoDTO> converterLista(List<Pedido> pedidos) {
        return pedidos.stream().map(PedidoDTO::new).collect(Collectors.toList());
    }

    public static PedidoDTO converter(Pedido pedido){
        return new PedidoDTO(pedido);
    }

}
