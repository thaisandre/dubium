package br.com.caelum.dubium.acao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AcaoFactory {
	
	@Autowired
	private ApplicationContext spring;

	public Acao getAcao(String action) {
		String nomeClasse = "br.com.caelum.dubium.acao." + action;
		System.out.println("nome da classe: " + nomeClasse);
		try {
			Class<?> clazz = Class.forName(nomeClasse);
			Acao acao = (Acao) spring.getBean(clazz);
			return acao;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
