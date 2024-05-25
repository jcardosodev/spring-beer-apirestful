package br.org.serratec.springbeer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.springbeer.model.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{

}
