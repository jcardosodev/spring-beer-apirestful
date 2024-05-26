package br.org.serratec.springbeer.dto;

public record RelacaoItemPedidoDto(
		Long idRelacao,
		Double percentualDesconto,
		String nomeProduto,
		Double valorUnitario,
		int quantidade,
		Double valorBruto,
		Double valorLiquido) {

}
