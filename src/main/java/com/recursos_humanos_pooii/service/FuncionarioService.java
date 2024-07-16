package com.recursos_humanos_pooii.service;

import org.springframework.stereotype.Service;

import com.recursos_humanos_pooii.model.Funcionario;
import com.recursos_humanos_pooii.model.Setor;
import com.recursos_humanos_pooii.repository.FuncionarioRepository;
import com.recursos_humanos_pooii.repository.SetorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;
    private SetorRepository setorRepository;

    public Funcionario salva(Funcionario funcionario) {
        if (funcionario.getSetor() != null && funcionario.getSetor().getId() != null) {
            Setor setor = setorRepository.findById(funcionario.getSetor().getId()).orElse(null);

            if (setor != null) {
                funcionario.setSetor(setor);
            }
        }

        funcionarioRepository.save(funcionario);
        
        return funcionario;
    }

    public void deleta(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public Funcionario buscaPorId(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }

    public Iterable<Funcionario> buscaTodos() {
        return funcionarioRepository.findAll();
    }

    public Iterable<Funcionario> buscaPorNome(String nome) {
        return funcionarioRepository.findAllByNome(nome);
    }
}
