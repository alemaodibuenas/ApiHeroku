package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SubCategoria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// indicar que o id é uma chave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subCategoriaID;
	
	@NotEmpty(message = "Campo TITULO é requerido")
	@Length(min = 3 , max = 100, message = " O campo TITULO deve ter entre 3 e 100 caracteres")
	private String descricao;
	
	// Iniciando relacionamento entre categoria e livros
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	// Iniciando o relacionamento
	private Categoria categoria;

	public SubCategoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubCategoria(Integer subCategoriaID, String descricao, com.example.demo.model.Categoria categoria) {
		super();
		this.subCategoriaID = subCategoriaID;
		this.descricao = descricao;
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(subCategoriaID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubCategoria other = (SubCategoria) obj;
		return Objects.equals(subCategoriaID, other.subCategoriaID);
	}

	public Integer getSubCategoriaID() {
		return subCategoriaID;
	}

	public void setSubCategoriaID(Integer subCategoriaID) {
		this.subCategoriaID = subCategoriaID;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
