package br.org.serratec.springbeer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.org.serratec.springbeer.config.Mapper;
import br.org.serratec.springbeer.model.ItemPedido;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ItemPedidoDto(
		
		 Long id,
		 int quantidade,
	     Double valorUnitario,
	     Double valorBruto,
	     Double percentualDesconto,
	     Double valorLiquido,
         PedidoDto pedido,
         ProdutoDto produto
		
		) {
	
	public ItemPedido toEntity() {
		return Mapper.getMapper().convertValue(this, ItemPedido.class);
	}
	
	public static ItemPedidoDto toDto(ItemPedido itemPedidoEntity) {
		return Mapper.getMapper().convertValue(itemPedidoEntity, ItemPedidoDto.class);
		
	}


}
