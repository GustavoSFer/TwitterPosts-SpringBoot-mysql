package com.fernandes.twitterPostMysql.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class Post implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Instant instant;
	private String titulo;
	private String texto;
	
	private User user;
	
	public Post() {}

	public Post(Integer id, Instant instant, String titulo, String texto, User user) {
		super();
		this.id = id;
		this.instant = instant;
		this.titulo = titulo;
		this.texto = texto;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getInstant() {
		return instant;
	}

	public void setInstant(Instant instant) {
		this.instant = instant;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}	
}
