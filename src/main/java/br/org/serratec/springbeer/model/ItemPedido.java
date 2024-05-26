package br.org.serratec.springbeer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "itempedidos")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int quantidade;
	private Double valorUnitario;
	private Double valorBruto;
	private Double percentualDesconto;
	private Double valorLiquido;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JsonBackReference
	private Pedido pedido;

	@ManyToOne(cascade=CascadeType.ALL)
	private Produto produto;

	public ItemPedido() {

	}

	public ItemPedido(Long id, int quantidade, Double valorUnitario, Double valorBruto,
			Double percentualDesconto, Double valorLiquido, Pedido pedido, Produto produto) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorBruto = valorBruto;
		this.percentualDesconto = percentualDesconto;
		this.valorLiquido = valorLiquido;
		this.pedido = pedido;
		this.produto = produto;
	}



	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Double getValorUnitario() {
		return valorUnitario;
	}
	
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	

	
	

}
