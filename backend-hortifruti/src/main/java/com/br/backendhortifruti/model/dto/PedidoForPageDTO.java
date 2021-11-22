package com.br.backendhortifruti.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.br.backendhortifruti.model.entity.Pedido;

import lombok.Getter;

@Getter
public class PedidoForPageDTO {
	
	private Integer codigo;
	
	private LocalDateTime dataHora;
	
	private String nomeCliente;
	
	private boolean situacao;
	
	private Integer quantidadeTotal;

	private Double valorFinal;

	public PedidoForPageDTO(Pedido pedido) {
		this.codigo = pedido.getCodigo();
		this.dataHora = pedido.getDataHora();
		this.nomeCliente = pedido.getCliente().getNome();
		this.situacao = pedido.isSituacao();
		this.quantidadeTotal = pedido.getQuantidadeTotal();
		this.valorFinal = pedido.getValorFinal();
	}
	
	public static List<PedidoForPageDTO> converterList(List<Pedido> pedidos) {
        return pedidos.stream().map(PedidoForPageDTO::new).collect(Collectors.toList());
    }
	
	
}