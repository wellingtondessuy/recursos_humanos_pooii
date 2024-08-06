package com.recursos_humanos_pooii.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private Float salario;

    @ManyToOne(cascade = CascadeType.ALL)
    private Setor setor;

    @ManyToMany
    @JoinTable(
        name = "treinamentos_funcionarios", 
        joinColumns = @JoinColumn(name = "funcionario_id"), 
        inverseJoinColumns = @JoinColumn(name = "treinamento_id"))
    @JsonBackReference
    private List<Treinamento> treinamentos = new ArrayList<>();
}
