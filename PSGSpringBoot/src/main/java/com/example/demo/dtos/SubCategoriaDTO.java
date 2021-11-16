package com.example.demo.dtos;

import java.io.Serializable;

import com.example.demo.model.SubCategoria;

public class SubCategoriaDTO implements Serializable  {

	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;
	
	public SubCategoriaDTO() {
		super();		
	}
	
	public SubCategoriaDTO(SubCategoria obj) {
		super();
		this.id = obj.getSubCategoriaID();
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
