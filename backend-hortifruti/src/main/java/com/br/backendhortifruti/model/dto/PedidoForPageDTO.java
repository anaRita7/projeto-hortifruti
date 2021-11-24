package com.br.backendhortifruti.model.dto;

import com.br.backendhortifruti.model.entity.Pedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PedidoForPageDTO {

	private Integer codigo;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm:ss")
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
