package com.aula.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Contato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome é Obrigatorio")
	@Column(length = 50, nullable = false)
	private String nome;
	
	
	
	@NotBlank(message = "Email é obrigatorio")
	@Email(message = "Email invalido")
	
	@Column(length = 50, nullable = false)
	private String email;
	
	@NotBlank(message = "Telefone Obrigatorio")
	@Size(max=14, min=14, message = "O telefone deve ter 14 caracteres")
	@Column(length = 14)
	private String fone;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updateAt;

	public Contato() {
	}

	public Contato(String nome, String email, String fone) {
		this.nome = nome;
		this.email = email;
		this.fone = fone;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public Instant getCreatedAt() {
		return createdAt;
	}

	@PrePersist
	public void setCreatedAt() {
		this.createdAt = Instant.now();
	}

	public Instant getUpdateAt() {
		return updateAt;
	}

	@PreUpdate
	public void setUpdateAt() {
		this.updateAt = Instant.now();
	}


}
