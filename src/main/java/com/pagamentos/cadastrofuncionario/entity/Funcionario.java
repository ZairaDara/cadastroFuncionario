package com.pagamentos.cadastrofuncionario.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @ManyToOne
    @JoinColumn(name = "idcargo")
    @NotNull
    private Cargo cargo;
    @NotNull(message = "Nome nao pode se null")
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotNull
    private String endereco;
    private Date dataNascimento;
    private Date dataContratacao;
    private BigDecimal bonusSalarial;


}
