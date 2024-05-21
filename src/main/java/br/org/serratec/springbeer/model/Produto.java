package br.org.serratec.springbeer.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
	
	private Long id_produto;
	private String descricao;
	private int quant_estoque;
	private LocalDate data_cadastro;
	private Double valor_unitario;
	private byte[] imagem;
	private Categoria categoria;
	
	
	public Produto() {
		
	}
	
	
	
	public Produto(Long id_produto, String descricao, int quant_estoque, LocalDate data_cadastro, Double valor_unitario,
			byte[] imagem, Categoria categoria) {
		super();
		this.id_produto = id_produto;
		this.descricao = descricao;
		this.quant_estoque = quant_estoque;
		this.data_cadastro = data_cadastro;
		this.valor_unitario = valor_unitario;
		this.imagem = imagem;
		this.categoria = categoria;
	}
	public Long getId_produto() {
		return id_produto;
	}
	public void setId_produto(Long id_produto) {
		this.id_produto = id_produto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuant_estoque() {
		return quant_estoque;
	}
	public void setQuant_estoque(int quant_estoque) {
		this.quant_estoque = quant_estoque;
	}
	public LocalDate getData_cadastro() {
		return data_cadastro;
	}
	public void setData_cadastro(LocalDate data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	public Double getValor_unitario() {
		return valor_unitario;
	}
	public void setValor_unitario(Double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
	

}
