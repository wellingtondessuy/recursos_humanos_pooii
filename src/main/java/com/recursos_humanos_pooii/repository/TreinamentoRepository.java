package com.recursos_humanos_pooii.repository;

import org.springframework.data.repository.CrudRepository;

import com.recursos_humanos_pooii.model.Treinamento;

public interface TreinamentoRepository extends CrudRepository<Treinamento, Long> {
    public Iterable<Treinamento> findAllByNome(String nome);
}
