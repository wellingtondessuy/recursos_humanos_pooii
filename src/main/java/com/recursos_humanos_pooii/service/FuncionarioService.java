package com.recursos_humanos_pooii.service;

import org.springframework.stereotype.Service;

import com.recursos_humanos_pooii.model.Funcionario;
import com.recursos_humanos_pooii.repository.FuncionarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    public Funcionario salva(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
        
        return funcionario;
    }

    public void deleta(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public Funcionario buscaPorId(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }
}
