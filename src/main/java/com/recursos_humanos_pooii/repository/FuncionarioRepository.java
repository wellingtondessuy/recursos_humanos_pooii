package com.recursos_humanos_pooii.repository;

// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.recursos_humanos_pooii.model.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
    public Iterable<Funcionario> findAllByNome(String nome);

    // @Query()
    // public Iterable<Funcionario> findAllQualquer(String nome);

    // public Long countByNome(String nome);
}
