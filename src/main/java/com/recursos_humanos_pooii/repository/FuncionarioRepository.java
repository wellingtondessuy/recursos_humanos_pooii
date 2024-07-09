package com.recursos_humanos_pooii.repository;

import org.springframework.data.repository.CrudRepository;

import com.recursos_humanos_pooii.model.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
    
}
