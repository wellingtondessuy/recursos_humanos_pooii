package com.recursos_humanos_pooii.service;

import org.springframework.stereotype.Service;

import com.recursos_humanos_pooii.repository.FuncionarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;


}
