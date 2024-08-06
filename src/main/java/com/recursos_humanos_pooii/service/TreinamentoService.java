package com.recursos_humanos_pooii.service;

import com.recursos_humanos_pooii.model.Funcionario;
import com.recursos_humanos_pooii.model.Treinamento;
import com.recursos_humanos_pooii.repository.TreinamentoRepository;
import com.recursos_humanos_pooii.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TreinamentoService {
    private TreinamentoRepository treinamentoRepository;
    private FuncionarioRepository funcionarioRepository;

    public Treinamento salva(Treinamento funcionario) {
        return treinamentoRepository.save(funcionario);
    }

    public Treinamento buscaPorId(Long id) {
        return treinamentoRepository.findById(id).orElse(null);
    }

    public Iterable<Treinamento> buscaTodos() {
        return treinamentoRepository.findAll();
    }

    public Iterable<Treinamento> buscaPorNome(String nome) {
        return treinamentoRepository.findAllByNomeContaining(nome);
    }

    public Treinamento adicionaInscrito(Long treinamentoId, Long funcionarioId) {
        Treinamento treinamento = treinamentoRepository.findById(treinamentoId).orElse(null);

        if (treinamento == null) {

            return null;
        }

        Funcionario funcionario = funcionarioRepository.findById(funcionarioId).orElse(null);

        if (funcionario == null) {

            return treinamento;
        }

        treinamento.adicionaInscrito(funcionario);

        return treinamentoRepository.save(treinamento);
    }
}
