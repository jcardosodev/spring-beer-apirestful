package br.org.serratec.springbeer.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.org.serratec.springbeer.config.Mapper;
import br.org.serratec.springbeer.model.Cliente;
import br.org.serratec.springbeer.model.Pedido;

public record PedidoDto(
			
	 Long id,
	 LocalDate dataPedido,
	 LocalDate dataEntrega,
	 LocalDate dataEnvio,
	 String status,
	 BigDecimal valorTotal,
	 Cliente cliente
		) {
	
	public Pedido toEntity() {
		return Mapper.getMapper().convertValue(this, Pedido.class);
	}
	
	

}
