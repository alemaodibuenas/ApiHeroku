package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Categoria;
import com.example.demo.model.SubCategoria;
import com.example.demo.repository.ISubCategoriaRepository;
import com.example.demo.service.exceptions.ObjectNotFoundException;

@Service
public class SubcategoriaService {
	
	@Autowired
	private ISubCategoriaRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	public SubCategoria findById(Integer id) {
		Optional<SubCategoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! id : " + id + " , Tipo: "
				+ SubCategoria.class.getName()));
		
	}

	public List<SubCategoria> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return repository.findAllByCategoria(id_cat);
		
		
	}

	public SubCategoria update(Integer id, SubCategoria obj) {
		SubCategoria newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);

	}

	private void updateData(SubCategoria newObj, SubCategoria obj) {
		newObj.setDescricao(obj.getDescricao());
	}

	public SubCategoria create(Integer id_cat, SubCategoria obj) {
		obj.setSubCategoriaID(null);
		//SubCategoria cat = categoriaService.findById(id_cat);
		Categoria cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		return repository.save(obj);
		
	}

	public void delete(Integer id) {
		SubCategoria obj = findById(id);
		repository.delete(obj);
		
	}

}
