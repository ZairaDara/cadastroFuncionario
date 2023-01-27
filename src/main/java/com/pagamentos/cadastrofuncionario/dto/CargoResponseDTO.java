package com.pagamentos.cadastrofuncionario.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class CargoResponseDTO {

    private Long idCargo;

    private String descricaoCargo;
    private BigDecimal salarioBase;

}
