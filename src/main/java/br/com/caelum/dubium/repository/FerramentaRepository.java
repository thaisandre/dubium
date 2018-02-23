package br.com.caelum.dubium.repository;

import java.util.Set;

import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import br.com.caelum.dubium.modelo.Ferramenta;

@Repository
public interface FerramentaRepository extends CrudRepository<Ferramenta, Long>, QueryByExampleExecutor<Ferramenta> {
	
	Set<Ferramenta> findAll(Example example);
}
