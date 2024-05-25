package br.org.serratec.springbeer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.springbeer.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
