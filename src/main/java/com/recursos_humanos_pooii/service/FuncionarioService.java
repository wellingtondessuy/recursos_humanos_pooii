package com.recursos_humanos_pooii.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.recursos_humanos_pooii.model.FolhaDePagamento;
import com.recursos_humanos_pooii.model.Funcionario;
import com.recursos_humanos_pooii.model.Setor;
import com.recursos_humanos_pooii.repository.FolhaDePagamentoRepository;
import com.recursos_humanos_pooii.repository.FuncionarioRepository;
import com.recursos_humanos_pooii.repository.SetorRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FuncionarioService {
    private FolhaDePagamentoRepository folhaDePagamentoRepository;
    private FuncionarioRepository funcionarioRepository;
    private SetorRepository setorRepository;

    @Transactional
    public Funcionario salva(Funcionario funcionario) {
        if (funcionario.getSetor() != null && funcionario.getSetor().getId() != null) {
            Setor setor = setorRepository.findById(funcionario.getSetor().getId()).orElse(null);

            if (setor != null) {
                funcionario.setSetor(setor);
            }
            
        }

        return funcionarioRepository.save(funcionario);
    }

    @Transactional
    public void deleta(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElse(null);

        if (funcionario == null) {

            return;
        }
        
        folhaDePagamentoRepository.deleteByFuncionario(funcionario);

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

    public FolhaDePagamento registraSalario(Long funcionarioId) {
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId).orElse(null);

        if (funcionario == null) {

            return null;
        }

        FolhaDePagamento folhaDePagamento = new FolhaDePagamento(funcionario);
        folhaDePagamentoRepository.save(folhaDePagamento);

        return folhaDePagamento;
    }

    public List<FolhaDePagamento> buscaFolhaDePagamento(Long funcionarioId, Date data) {
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId).orElse(null);

        if (funcionario == null) {

            return null;
        }

        return folhaDePagamentoRepository.findByData(data);
    }

    public List<FolhaDePagamento> buscaFolhaDePagamentoComIrrf() {
        return folhaDePagamentoRepository.findByIrrfGreaterThan(0f);
    }
}
