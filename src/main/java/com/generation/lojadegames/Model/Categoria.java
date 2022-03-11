package com.generation.lojadegames.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // é o mesmo que: use db_lojadegames
	@Table(name = "tb_categoria") //criando tabela
	public class Categoria {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincremente
		private Long id;
		
		@NotBlank(message = "O nome da categoria é obrigatório!")
		@Size(min = 3, max = 50, message = "O nome pode conter até 50 caracteres." )
		private String nome;
		
		@NotBlank(message= "A descrição é obrigatória.")
		@Size(min = 10, max = 100, message = "Inclua uma descrição com até 100 caracteres..." )
		private String descricao;
		
		@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
		@JsonIgnoreProperties("categoria")
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
		
}
