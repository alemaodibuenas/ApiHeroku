package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dtos.SubCategoriaDTO;
import com.example.demo.model.SubCategoria;
import com.example.demo.service.SubcategoriaService;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api")
public class SubCategoriaController {	
	
	@Autowired
	private SubcategoriaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SubCategoria> findById(@PathVariable Integer id){
		SubCategoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}	
	
	@GetMapping
	public ResponseEntity<List<SubCategoriaDTO>> findAll(@RequestParam(value = "categoria", defaultValue ="0") Integer id_cat) {
		List<SubCategoria> list = service.findAll(id_cat);
		List<SubCategoriaDTO> listDTO = list.stream().map(obj -> new SubCategoriaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
 		
	}
	
	@PutMapping (value = "/{id}")
	public ResponseEntity<SubCategoria> update (@PathVariable Integer id,  @Valid @RequestBody SubCategoria obj) {
		SubCategoria newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
		
		
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<SubCategoria> updatePatch (@PathVariable Integer id,@Valid @RequestBody  SubCategoria obj){
		SubCategoria newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	

	@PostMapping
	public ResponseEntity<SubCategoria> create(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
			@Valid @RequestBody SubCategoria obj) {
		SubCategoria newObj = service.create(id_cat, obj);
	URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livros/{id}").buildAndExpand(newObj.getSubCategoriaID()).toUri();
	return ResponseEntity.created(uri).build();

	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
		
	}
}
