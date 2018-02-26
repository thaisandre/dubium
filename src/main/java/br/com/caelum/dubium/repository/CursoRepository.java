package br.com.caelum.dubium.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import br.com.caelum.dubium.modelo.Curso;
import br.com.caelum.dubium.modelo.Ferramenta;

public interface CursoRepository extends CrudRepository<Curso, Long> {
	
	Set<Curso> findByFerramentasIn(List<Ferramenta> ferramentas);
}
