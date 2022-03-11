package com.generation.lojadegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.lojadegames.Model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	List<Categoria>findAllByDescricaoContainingIgnoreCase(String descricao);

}
