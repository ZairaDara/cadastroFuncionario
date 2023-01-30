package com.pagamentos.cadastrofuncionario.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
//comentario para testar
@Getter
@Setter
@Entity
@ToString
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCargo")
    private Cargo cargo;

    private String nome;
    private String endereco;
    private Date dataNascimento;
    private Date dataContratacao;
    private BigDecimal bonusSalarial;

}
