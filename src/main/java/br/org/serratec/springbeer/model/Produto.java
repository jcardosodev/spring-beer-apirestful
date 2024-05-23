package br.org.serratec.springbeer.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private int quantidadeEstoque;
	private LocalDate dataCadastro;
	private Double valorUnitario;
	@Lob
	private byte[] imagem;
	@ManyToOne
	private Categoria categoria;

	public Produto() {

	}

	public Produto(Long id, String descricao, int quantidadeEstoque, LocalDate dataCadastro,
			Double valorUnitario, byte[] imagem, Categoria categoria) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.quantidadeEstoque = quantidadeEstoque;
		this.dataCadastro = dataCadastro;
		this.valorUnitario = valorUnitario;
		this.imagem = imagem;
		this.categoria = categoria;
	}

	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getquantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setquantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public LocalDate getdataCadastro() {
		return dataCadastro;
	}

	public void setdataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Double getvalorUnitario() {
		return valorUnitario;
	}

	public void setvalorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
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
