package br.com.caelum.dubium.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import br.com.caelum.dubium.modelo.Carreira;
import br.com.caelum.dubium.modelo.Ferramenta;

@Repository
public interface CarreiraRepository extends CrudRepository<Carreira, Long>, QueryByExampleExecutor<Ferramenta> {
	
	Set<Carreira> findByFerramentasIn(List<Ferramenta> ferramentas);

}
