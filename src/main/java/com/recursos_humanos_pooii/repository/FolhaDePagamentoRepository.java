package com.recursos_humanos_pooii.repository;

import org.springframework.data.repository.CrudRepository;

import com.recursos_humanos_pooii.model.FolhaDePagamento;
import com.recursos_humanos_pooii.model.Funcionario;

import java.util.List;
import java.sql.Date;

public interface FolhaDePagamentoRepository extends CrudRepository<FolhaDePagamento, Long> {
    public List<FolhaDePagamento> findByData(Date data);

    public List<FolhaDePagamento> findByIrrfGreaterThan(Float minimum);

    public void deleteByFuncionario(Funcionario funcionario);
}
