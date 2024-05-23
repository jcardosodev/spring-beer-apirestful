package br.org.serratec.springbeer.dto;

import java.math.BigDecimal;

import br.org.serratec.springbeer.config.Mapper;
import br.org.serratec.springbeer.model.ItemPedido;
import br.org.serratec.springbeer.model.Pedido;
import br.org.serratec.springbeer.model.Produto;

public record ItemPedidoDto(
		
		 Long id,
		 int quantidade,
	     BigDecimal precoVenda,
	     BigDecimal valorBruto,
	     BigDecimal percentualDesconto,
	     BigDecimal valorLiquido,
         Pedido pedido,
         Produto produto
		
		) {
	
	public ItemPedido toEntity() {
		return Mapper.getMapper().convertValue(this, ItemPedido.class);
	}
	
	public static ItemPedidoDto toDto(ItemPedidoDto itemPedidoEntity) {
		return Mapper.getMapper().convertValue(itemPedidoEntity, ItemPedidoDto.class);
		
	}

}
