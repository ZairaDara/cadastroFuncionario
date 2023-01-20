package com.pagamentos.cadastrofuncionario.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.security.PrivateKey;
import java.util.Date;
//comentario para testar
@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cargo cargo;

    private String nome;
    private String endereco;
    private Date dataNascimento;
    private Date dataContratacao;
    private BigDecimal bonusSalarial;



}