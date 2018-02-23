package br.com.caelum.dubium.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import br.com.caelum.dubium.modelo.Carreira;
import br.com.caelum.dubium.modelo.Ferramenta;

@Repository
public interface CarreiraRepository extends CrudRepository<Ferramenta, Long>, QueryByExampleExecutor<Ferramenta> {
	
	Set<Carreira> findByFerramentasIn(List<Ferramenta> ferramentas);

	Iterable<Carreira> findByFerramentasLike(List<Ferramenta> ferramentas);
}
