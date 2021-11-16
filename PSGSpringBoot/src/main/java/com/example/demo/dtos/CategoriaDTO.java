package com.example.demo.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.example.demo.model.Categoria;


public class CategoriaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Campo DESCRIÇÃO é requerido")
	@Length(min = 3 , max = 100, message = " O campo DESCRIÇÃO deve ter entre 3 e 100 caracteres")
	private String descricao;
	
	
	public CategoriaDTO() {
		super();
		
	}
	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getCategoriaID();
		this.descricao = obj.getDescricao();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
