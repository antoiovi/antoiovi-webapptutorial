package com.antoiovi.a1jdbcbase.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

public class Person {

	@NotNull
	private Long id;

 	@Size(min = 4, max = 10)
	private String username;

 	@Size(min = 2, max = 25)
	private String nome;

 	@Size(min = 2, max = 25)
	private String cognome;

	//  @Email ????
		String email;

 	@Size(min = 4, max = 10)
	private String password;

	public Person() {
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (username != null && !username.trim().isEmpty())
			result += "username: " + username;
		if (nome != null && !nome.trim().isEmpty())
			result += ", nome: " + nome;
		if (cognome != null && !cognome.trim().isEmpty())
			result += ", cognome: " + cognome;
		if (email != null && !email.trim().isEmpty())
			result += ", email: " + email;
		if (password != null && !password.trim().isEmpty())
			result += ", password: " + password;
		return result;
	}


}
