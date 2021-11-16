package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


@Entity
public class Categoria implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoriaID;

	@NotEmpty(message = "Campo DESCRIÇÃO é requerido")
	@Length(min = 3 , max = 100, message = " O campo DESCRIÇÃO deve ter entre 3 e 100 caracteres")
	private String descricao;
	
	// Iniciando relacionamento entre categoria e livros
	
	@OneToMany(mappedBy = "categoria")
	
	private List<SubCategoria> sub = new ArrayList<>();

	public Categoria() {
		super();		
	}

	public Integer getCategoriaID() {
		return categoriaID;
	}

	public void setCategoriaID(Integer categoriaID) {
		this.categoriaID = categoriaID;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria(Integer categoriaID, String descricao) {
		super();
		this.categoriaID = categoriaID;
		this.descricao = descricao;
	}


	@Override
	public int hashCode() {
		return Objects.hash(categoriaID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(categoriaID, other.categoriaID);
	}
	
	public List<SubCategoria> getSubCategorias() {
		return sub;
	}

	public void setSubCategorias(List<SubCategoria> sub) {
		this.sub = sub;
	}
}