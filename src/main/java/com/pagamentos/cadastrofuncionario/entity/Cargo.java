package com.pagamentos.cadastrofuncionario.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
public class Cargo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "idcargo")
    private Long idCargo;
    private String descricaoCargo;
    private BigDecimal salarioBase;

    @OneToMany(mappedBy = "cargo",fetch = FetchType.LAZY)
    private Set<Funcionario> listaFuncionarios;
}
