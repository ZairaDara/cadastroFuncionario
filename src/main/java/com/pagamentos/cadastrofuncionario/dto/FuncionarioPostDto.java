package com.pagamentos.cadastrofuncionario.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
@ToString
public class FuncionarioPostDto {
    private Long idCargo;
    private String nome;
    private String endereco;
    private Date dataNascimento;
    private Date dataContratacao;
    private BigDecimal bonusSalarial;
}
