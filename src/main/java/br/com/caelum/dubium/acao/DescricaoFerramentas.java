package br.com.caelum.dubium.acao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.caelum.dubium.modelo.Ferramenta;
import br.com.caelum.dubium.repository.FerramentaRepository;

@Component
public class DescricaoFerramentas implements Acao {
	
	@Autowired
	private FerramentaRepository ferramentaRepository;

	@Override
	public String executa(List<String> params, String operador) {
		System.out.println("ENTROU NO EXECUTA DO DESCRIÇÃO");
		System.out.println(params.toString());
		
		List<Ferramenta> ferramentas = new ArrayList<>();
		for(String s : params){
			for(Ferramenta f: ferramentaRepository.findAll()) {
				if(s.equals(f.getNome())){
					ferramentas.add(f);
				}
			}
		}
		System.out.println("ferramentas: " + ferramentas.toString());

		if (ferramentas.isEmpty()) {
			return "não temos informações das ferramentas " + params;
		} else {
			String resp = "";
			for (int i = 0; i < ferramentas.size(); i++) {
				if (i == ferramentas.size() - 1) {
					resp += "*" + ferramentas.get(i).getNome() + "*[" + ferramentas.get(i).getCategoria().getNome() + "] - " + ferramentas.get(i).getDescricao() + ".";
				} else {
					resp += "*" + ferramentas.get(i).getNome() + "*[" + ferramentas.get(i).getCategoria().getNome() + "] - " + ferramentas.get(i).getDescricao() + "\n";
				}
			}
			return "entendi, você deseja saber sobre as ferramentas " + params + ". segue: " + "\n" + resp;
		}
	}
}
