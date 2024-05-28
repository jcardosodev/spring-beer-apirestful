package br.org.serratec.springbeer.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.org.serratec.springbeer.config.Mapper;
import br.org.serratec.springbeer.model.Pedido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
	
	public RelatorioDto relatorioToDto() {
	    
	    List<RelacaoItemPedidoDto> relatorioItem = new ArrayList<>();
	    this.itemPedido.forEach(item -> {
	    	relatorioItem.add(item.itemPedidoRelatorioToDto());
	    });
	      
	    return new RelatorioDto(
	            this.id,
	            this.dataPedido,
	            relatorioItem,
	            this.valorTotal
	               
	    );  
	}

}
