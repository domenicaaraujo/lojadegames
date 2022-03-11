package com.generation.lojadegames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.lojadegames.Model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long>{
		List<Produto>findAllByNomeContainingIgnoreCase(String nome);

	}

