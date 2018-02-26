package br.com.caelum.dubium.acao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.caelum.dubium.modelo.Carreira;
import br.com.caelum.dubium.modelo.Ferramenta;
import br.com.caelum.dubium.repository.CarreiraRepository;
import br.com.caelum.dubium.repository.FerramentaRepository;

@Component
public class CarreiraPorFerramentas implements Acao {
	
	@Autowired
	FerramentaRepository ferramentaRepository;
	
	@Autowired
	CarreiraRepository carreiraRepository;
	
	
	@Override
	public String executa(List<String> params, String operador) {
		System.out.println("entrou no EXECUTA de Carreiras");
		System.out.println("params: " + params);
		System.out.println("operador: " + operador);

		List<Ferramenta> ferramentas = criaLista(params);
		System.out.println("ferramentas: " + ferramentas.toString());

		Set<Carreira> carreiras = carreiraRepository.findByFerramentasIn(ferramentas);
		System.out.println("carreiras: " + carreiras.toString());

		List<Carreira> listaCarreiras = criaLista(carreiras, ferramentas, operador);

		return constroiResposta(listaCarreiras, params);
	}
	
	private List<Ferramenta> criaLista(List<String> params) {
		List<Ferramenta> ferramentas = new ArrayList<>();
		for (String s : params) {
			for (Ferramenta f : ferramentaRepository.findAll()) {
				if (s.equals(f.getNome())) {
					ferramentas.add(f);
				}
			}
		}

		return ferramentas;
	}
	
	private List<Carreira> criaLista(Set<Carreira> carreiras, List<Ferramenta> ferramentas, String operador) {
		List<Carreira> listaCarreiras = new ArrayList<>();

		if (operador.equals("ou")) {
			for (Carreira carreira : carreiras) {
				listaCarreiras.add(carreira);
			}
		} else {

			int cont = 0;
			System.out.println("numero ferramentas: " + ferramentas.size());
			for (Carreira carreira : carreiras) {
				for (Ferramenta ferramenta : ferramentas) {
					if (carreira.getFerramentas().contains(ferramenta)) {
						cont++;
						System.out.println(carreira + "entrou no if e cont: " + cont);
					}
				}
				if (cont == ferramentas.size()) {
					listaCarreiras.add(carreira);
				}
				cont = 0;
			}
		}

		return listaCarreiras;
	}
	
	private String constroiResposta(List<Carreira> listaCarreiras, List<String> params) {
		if (listaCarreiras.isEmpty()) {
			return "não sabemos responder sobre carreiras de " + params
					+ ". use o canal *duvidas_comercial* para este fim.";
		} else {

			String resp = "";
			for (int i = 0; i < listaCarreiras.size(); i++) {
				if (i == listaCarreiras.size() - 1) {
					resp += "*" + listaCarreiras.get(i).getNome() + "*" + listaCarreiras.get(i).getFerramentas() + "\n"
							+ listaCarreiras.get(i).getLink() + ".\n";
				} else {
					resp += "*" + listaCarreiras.get(i).getNome() + "*" + listaCarreiras.get(i).getFerramentas() + "\n"
							+ listaCarreiras.get(i).getLink() + "\n\n";
				}
			}
			return "entendi, você deseja saber as carreiras sobre " + params + ". segue: " + "\n\n" + resp;
		}
	}
}
