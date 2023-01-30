package com.pagamentos.cadastrofuncionario.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
public class Cargo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "idCargo")
    private Long idCargo;
    private String descricaoCargo;
    private BigDecimal salarioBase;

    @OneToMany(mappedBy = "cargo",cascade = CascadeType.ALL)
    private Set<Funcionario> listaFuncionarios;
}
