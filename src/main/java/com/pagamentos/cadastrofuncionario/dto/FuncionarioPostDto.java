package com.pagamentos.cadastrofuncionario.dto;

import java.math.BigDecimal;
import java.util.Date;
public class FuncionarioPostDto {
    private Long idCargo;
    private String nome;
    private String endereco;
    private Date dataNascimento;
    private Date dataContratacao;
    private BigDecimal bonusSalarial;
}
