package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {}
