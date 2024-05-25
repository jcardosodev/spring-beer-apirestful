package br.org.serratec.springbeer.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.org.serratec.springbeer.config.Mapper;
import br.org.serratec.springbeer.model.Pedido;

@JsonIgnoreProperties(ignoreUnknown = true)

public record PedidoDto(
			
	 Long id,
	 LocalDate dataPedido,
	 LocalDate dataEntrega,
	 LocalDate dataEnvio,
	 String status,
	 Double valorTotal,
	 ClienteDto cliente,
	 List<ItemPedidoDto> itemPedido
	 	 
		) {
	
	public Pedido toEntity() {
		return Mapper.getMapper().convertValue(this, Pedido.class);
	}
	
	public static PedidoDto toDto(Pedido pedidoEntity) {
		return Mapper.getMapper().convertValue(pedidoEntity, PedidoDto.class);
	}
	
//	public List<ItemPedidoDto> getItensPedido() {
//	        return itensPedido == null ? List.of() : itensPedido;
//	}

}
