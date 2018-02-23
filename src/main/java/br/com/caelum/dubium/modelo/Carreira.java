package br.com.caelum.dubium.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Carreira {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String link;
	
	@Enumerated(EnumType.STRING)
	private CategoriaCarreira categoria;
	
	@ManyToMany
	private List<Ferramenta> ferramentas;
	
	public Carreira() {
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<Ferramenta> getFerramentas() {
		return ferramentas;
	}

	public void setFerramentas(List<Ferramenta> ferramentas) {
		this.ferramentas = ferramentas;
	}

	public CategoriaCarreira getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaCarreira categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
