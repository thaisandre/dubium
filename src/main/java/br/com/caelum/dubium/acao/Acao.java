package br.com.caelum.dubium.acao;

import java.util.List;

public interface Acao {
	
	public String executa(List<String> params, String operador);
}
