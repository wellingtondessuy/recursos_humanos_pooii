package com.recursos_humanos_pooii.controller;

import org.springframework.web.bind.annotation.RestController;

import com.recursos_humanos_pooii.model.FolhaDePagamento;
import com.recursos_humanos_pooii.model.Funcionario;
import com.recursos_humanos_pooii.service.FuncionarioService;

import lombok.AllArgsConstructor;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@AllArgsConstructor
public class FuncionarioController {
    private FuncionarioService funcionarioService;

    @PostMapping("/funcionarios/salvar")
    public Funcionario postMethodName(Funcionario funcionario) {
        return funcionarioService.salva(funcionario);
    }

    @PostMapping("/funcionarios/deletar")
    public void deleteMethodName(Long id) {
        funcionarioService.deleta(id);
    }

    @GetMapping("/funcionarios/{id}")
    public Funcionario getMethodName(@PathVariable("id") Long id) {
        return funcionarioService.buscaPorId(id);
    }

    @GetMapping("/funcionarios")
    public Iterable<Funcionario> getMethodName(String nome) {
        return funcionarioService.buscaPorNome(nome);
    }

    @PostMapping("/funcionarios/{id}/registra_salario")
    public FolhaDePagamento postMethodName(@PathVariable("id") Long id) {
        return funcionarioService.registraSalario(id);
    }

    @GetMapping("/funcionarios/{id}/busca_salarios")
    public List<FolhaDePagamento> postMethodName(@PathVariable("id") Long id, Date data) {
        return funcionarioService.buscaFolhaDePagamento(id, data);
    }

    @GetMapping("/funcionarios/busca_salarios_com_irrf")
    public List<FolhaDePagamento> postMethodName() {
        return funcionarioService.buscaFolhaDePagamentoComIrrf();
    }
}
