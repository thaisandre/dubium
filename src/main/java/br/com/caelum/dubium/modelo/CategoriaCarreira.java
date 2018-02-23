package br.com.caelum.dubium.modelo;

public enum CategoriaCarreira {
	
	MOBILE ("mobile"),
	PROGRAMACAO ("programação"),
	INFRAESTRUTURA ("infraestrutura"),
	FRONTEND ("front-end"),
	BUSINESS ("business");
	
	String nome;
	
	CategoriaCarreira(String nome) {
		this.nome = nome;
	}
}
