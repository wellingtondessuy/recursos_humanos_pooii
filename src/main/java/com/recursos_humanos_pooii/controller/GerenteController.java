package com.recursos_humanos_pooii.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recursos_humanos_pooii.model.Funcionario;
import com.recursos_humanos_pooii.model.Gerente;
import com.recursos_humanos_pooii.service.GerenteService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class GerenteController {
    private GerenteService gerenteService;

    @PostMapping("/gerentes/salvar")
    public Gerente postMethodName(Gerente gerente) {
        return gerenteService.salva(gerente);
    }

    @GetMapping("/gerentes/{id}")
    public Funcionario getMethodName(@PathVariable("id") Long id) {
        return gerenteService.buscaPorId(id);
    }
}
