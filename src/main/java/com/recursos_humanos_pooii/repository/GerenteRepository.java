package com.recursos_humanos_pooii.repository;

import org.springframework.data.repository.CrudRepository;

import com.recursos_humanos_pooii.model.Gerente;

public interface GerenteRepository extends CrudRepository<Gerente, Long> {
    public Iterable<Gerente> findAllByNome(String nome);
}
