package com.recursos_humanos_pooii.service;

import org.springframework.stereotype.Service;

import com.recursos_humanos_pooii.model.Gerente;
import com.recursos_humanos_pooii.model.Setor;
import com.recursos_humanos_pooii.repository.GerenteRepository;
import com.recursos_humanos_pooii.repository.SetorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GerenteService {
    private GerenteRepository gerenteRepository;
    private SetorRepository setorRepository;

    public Gerente salva(Gerente gerente) {
        if (gerente.getSetor() != null && gerente.getSetor().getId() != null) {
            Setor setor = setorRepository.findById(gerente.getSetor().getId()).orElse(null);

            if (setor != null) {
                gerente.setSetor(setor);
            }
        }

        gerenteRepository.save(gerente);
        
        return gerente;
    }

    public void deleta(Long id) {
        gerenteRepository.deleteById(id);
    }

    public Gerente buscaPorId(Long id) {
        return gerenteRepository.findById(id).orElse(null);
    }

    public Iterable<Gerente> buscaTodos() {
        return gerenteRepository.findAll();
    }

    public Iterable<Gerente> buscaPorNome(String nome) {
        return gerenteRepository.findAllByNome(nome);
    }
}
