package br.com.caelum.dubium.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TipoFerramenta {
	
	NAO_DEFINIDA ("não definida"),
	BANCO_DE_DADOS ("banco de dados"),
	LINGUAGEM_DE_PROGRAMACAO("linguagem de programação"),
	LINGUAGEM_DE_MARCACAO ("linguagem de marcaoção"),
	FOLHA_DE_ESTILO ("folha de estilo"),
	FRAMEWORK ("framework"),
	API ("API"),
	BIBLIOTECA ("biblioteca"),
	ESPECIFICACAO ("especificacao"),
	IDE ("IDE"),
	PLATAFORMA ("plataforma"),
	PROTOCOLO ("protocolo"),
	BUILD ("ferrameta de build"),
	VERSIONAMENTO ("ferramenta de versionamento"),
	OUTROS ("outros");
	
	private String nome;
	
	TipoFerramenta(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return this.nome;
	}
	
	public static List<String> carregarAtributos() {
		List<TipoFerramenta> lista = Arrays.asList(TipoFerramenta.values());
		List<String> retorno = new ArrayList<String>();
		for(int i = 0; i < lista.size(); i++) {
			retorno.add(lista.get(i).getNome());
		}
		
		return retorno;
	}
}
