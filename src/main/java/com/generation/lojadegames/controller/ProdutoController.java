package com.generation.lojadegames.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.lojadegames.Model.Produto;
import com.generation.lojadegames.repository.ProdutoRepository;
@RestController // requisição
@RequestMapping("/todosprodutos") // resposta (sem o requestmapping não funciona.
@CrossOrigin(origins = "*", allowedHeaders = "*") /* comunicação entre o front o back */
public class ProdutoController {
	
		@Autowired // injeção de dependencia
		private ProdutoRepository produtoRepository;
		
		@GetMapping // trazer as informações do link /nomedado
		public ResponseEntity<List<Produto>> getAll() {  //
			return ResponseEntity.ok(produtoRepository.findAll());
			// select * from tb_postagens
		}
		//@PathVariable - pega o caminho da variavel, caminho que esta no GetMapping
		@GetMapping("/{id}")
		public ResponseEntity<Produto> getById(@PathVariable Long id) {
			return produtoRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
					.orElse(ResponseEntity.notFound().build());
		}

		@GetMapping("/nome/{nome}")
		public ResponseEntity<List<Produto>> getByDescricao(@PathVariable String  nome) {
			return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));

		}
	//Salvando itens na lista;
		@PostMapping
		public ResponseEntity<Produto> postCategoria(@Valid @RequestBody Produto produto){
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(produtoRepository.save(produto));
		}
		//Atualizando dados da lista
		@PutMapping
		public ResponseEntity<Produto> atualizaProduto (@Valid @RequestBody Produto produto){
			return ResponseEntity.status(HttpStatus.OK)
					.body(produtoRepository.save(produto));
		}
		
		@DeleteMapping("/{id}")
		public void apagarCategoria(@PathVariable Long id) {
			Optional<Produto> produto = produtoRepository.findById(id);
			if (produto.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
			
		}
			produtoRepository.deleteById(id);
		}
		
	}

