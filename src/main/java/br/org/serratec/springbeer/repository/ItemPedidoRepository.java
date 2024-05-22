package br.org.serratec.springbeer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.springbeer.model.ItemPedido;
@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{

}
