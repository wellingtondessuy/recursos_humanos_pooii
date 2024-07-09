package com.recursos_humanos_pooii.controller;

import org.springframework.web.bind.annotation.RestController;

import com.recursos_humanos_pooii.model.Funcionario;
import com.recursos_humanos_pooii.service.FuncionarioService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@AllArgsConstructor
public class FuncionarioController {
    private FuncionarioService funcionarioService;

    @PostMapping("/funcionarios/salvar")
    public Funcionario postMethodName(Funcionario funcionario) {
        funcionarioService.salva(funcionario);
        
        return funcionario;
    }

    @PostMapping("/funcionarios/deletar")
    public void deleteMethodName(Long id) {
        funcionarioService.deleta(id);
    }

    @GetMapping("/funcionarios/{id}")
    public Funcionario getMethodName(@PathVariable("id") Long id) {
        return funcionarioService.buscaPorId(id);
    }
}
