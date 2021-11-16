package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SubCategoria;

@Repository
public interface ISubCategoriaRepository extends JpaRepository<SubCategoria, Integer> {
	
	@Query("SELECT obj FROM SubCategoria obj WHERE obj.categoria.id = :id_cat ORDER BY descricao")	
	List<SubCategoria> findAllByCategoria(@Param(value = "id_cat")Integer id_cat);	
	
}
