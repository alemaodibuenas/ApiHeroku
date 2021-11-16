package com.example.demo.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Categoria;
import com.example.demo.model.SubCategoria;
import com.example.demo.repository.ICategoriaRepository;
import com.example.demo.repository.ISubCategoriaRepository;



@Service
public class DBService {

	@Autowired
	private ICategoriaRepository repo;

	@Autowired
	ISubCategoriaRepository repository;

	public void instanciaBaseDeDados() {

		// instanciando categoria

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Ficção cientifica");
		Categoria cat3 = new Categoria(null, "Futebol");

		// instanciando Livro

		SubCategoria l1 = new SubCategoria(null, "Clean code ", cat1);
		SubCategoria l2 = new SubCategoria(null, "Ficção ", cat2);
		SubCategoria l3 = new SubCategoria(null, "Basket ", cat3);
		SubCategoria l4 = new SubCategoria(null, "esporte ", cat2);
		SubCategoria l5 = new SubCategoria(null, "volei ", cat2);

		// Fazenendo a categoria conhecer o seu livro e o livro conhecer sua categoria
		cat1.getSubCategorias().addAll(Arrays.asList(l1, l2));
		cat2.getSubCategorias().addAll(Arrays.asList(l3, l4, l5));

		this.repo.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.repository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}

}
