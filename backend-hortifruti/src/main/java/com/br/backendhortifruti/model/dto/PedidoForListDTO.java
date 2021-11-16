package com.br.backendhortifruti.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.br.backendhortifruti.model.entity.Pedido;

import lombok.Getter;

@Getter
public class PedidoForListDTO {
	
	private Integer codigo;
	
	private LocalDateTime dataHora;
	
	private String nomeCliente;
	
	private boolean situacao;
	
	private Integer quantidadeTotal;

	private Double valorFinal;

	public PedidoForListDTO(Pedido pedido) {
		this.codigo = pedido.getCodigo();
		this.dataHora = pedido.getDataHora();
		this.nomeCliente = pedido.getCliente().getNome();
		this.situacao = pedido.isSituacao();
		this.quantidadeTotal = pedido.getQuantidadeTotal();
		this.valorFinal = pedido.getValorFinal();
	}
	
	public static List<PedidoForListDTO> converterList(List<Pedido> pedidos) {
        return pedidos.stream().map(PedidoForListDTO::new).collect(Collectors.toList());
    }
	
	
}
