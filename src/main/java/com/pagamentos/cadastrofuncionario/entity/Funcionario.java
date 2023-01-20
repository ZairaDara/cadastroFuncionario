package com.pagamentos.cadastrofuncionario.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.security.PrivateKey;
import java.util.Date;
//comentario para testar
@Getter
@Setter
@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idcargo")
    private Cargo cargo;

    private String nome;
    private String endereco;
    private Date dataNascimento;
    private Date dataContratacao;
    private BigDecimal bonusSalarial;



}
