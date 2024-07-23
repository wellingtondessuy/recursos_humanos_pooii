package com.recursos_humanos_pooii.controller;

import com.recursos_humanos_pooii.model.Treinamento;
import com.recursos_humanos_pooii.service.TreinamentoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TreinamentoController {
    private TreinamentoService treinamentoService;

    @PostMapping("/treinamentos/salvar")
    public Treinamento postMethodName(Treinamento treinamento) {
        return treinamentoService.salva(treinamento);
    }

    @PostMapping("/treinamentos/deletar")
    public void deleteMethodName(Long id) {
        treinamentoService.deleta(id);
    }

    @GetMapping("/treinamentos/{id}")
    public Treinamento getMethodName(@PathVariable("id") Long id) {
        return treinamentoService.buscaPorId(id);
    }

    @GetMapping("/treinamentos")
    public Iterable<Treinamento> getMethodName(String nome) {
        return treinamentoService.buscaPorNome(nome);
    }

    @PostMapping("/treinamentos/{id}/inscrever/{funcionario_id}")
    public Treinamento postMethodName(@PathVariable("id") Long id, @PathVariable("funcionario_id") Long funcionarioId) {
        return treinamentoService.adicionaInscrito(id, funcionarioId);
    }
}
