package com.pagamentos.cadastrofuncionario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private Long idCargo;
    private String nome;
    private String endereco;
    private Date dataNascimento;
    private Date dataContratacao;
    private BigDecimal bonusSalarial;
}
