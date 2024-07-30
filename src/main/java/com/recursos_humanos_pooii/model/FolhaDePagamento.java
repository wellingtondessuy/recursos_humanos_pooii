package com.recursos_humanos_pooii.model;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FolhaDePagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    private Float salario;
    private Float inss;
    private Float irrf;
    private Float salarioLiquido;

    @ManyToOne(cascade=CascadeType.ALL)
    private Funcionario funcionario;

    public FolhaDePagamento (Funcionario funcionario) {
        this.funcionario = funcionario;

        if (funcionario instanceof Gerente) {
            Gerente gerente = (Gerente) funcionario;

            this.salario = gerente.getSalario() + gerente.getAdicional();
        } else {
            this.salario = funcionario.getSalario();
        }

        LocalDate localDate = LocalDate.now();
        this.data = Date.valueOf(localDate);
        
        this.calculaInss();
        this.calculaIrrf();
        this.calculaSalarioLiquido();
    }

    private void calculaInss () {
        if (this.salario == 0) {
            this.inss = 0f;
        } else {
            this.inss = this.salario * 0.08f;
        }
    }

    private void calculaIrrf () {
        if (this.salario == 0) {
            this.irrf = 0f;
        } else {
            if (this.salario <= 1200) {
                this.irrf = 0f;
            } else if (this.salario <= 2500) {
                this.irrf = this.salario * 0.1f;
            } else if (this.salario <= 4300) {
                this.irrf = this.salario * 0.15f;
            } else if (this.salario <= 6400) {
                this.irrf = this.salario * 0.2f;
            } else {
                this.irrf = this.salario * 0.27f;
            }
        }
    }

    private void calculaSalarioLiquido () {
        this.salarioLiquido = this.salario - this.inss - this.irrf;
    }
}
