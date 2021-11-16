package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.CategoriaDTO;
import com.example.demo.model.Categoria;
import com.example.demo.repository.ICategoriaRepository;
import com.example.demo.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private ICategoriaRepository repo;
	
	public Categoria findById(Integer id) {
		java.util.Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! id: "
				+ id  + ", Tipo " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll(){
		return repo.findAll();	
	}
	//Metodo create
	public Categoria create(Categoria obj) {
		obj.setCategoriaID(null);
		return repo.save(obj);
	}
	//Metodo update
	public Categoria update(Integer id, CategoriaDTO objDto) {
		Categoria obj = findById(id);
		obj.setDescricao(objDto.getDescricao());
		return repo.save(obj);
	}
	//Metodo delete
	public void delete(Integer id) {
		findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.example.demo.service.exceptions.DataIntegrityViolationException(
			"Categoria nao pode ser deletado! Possui livros associados");			
		}		
		
	}

}
