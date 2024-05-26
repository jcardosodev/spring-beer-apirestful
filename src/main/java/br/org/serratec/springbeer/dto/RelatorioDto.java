package br.org.serratec.springbeer.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RelatorioDto(
		
		Long relatorioId,
		LocalDate dataPedido,
		List<RelacaoItemPedidoDto> relacaoItemPedido,
		Double valorTotal
		) {
	
	
}
