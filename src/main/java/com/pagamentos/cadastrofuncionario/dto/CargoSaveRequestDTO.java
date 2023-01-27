package com.pagamentos.cadastrofuncionario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class CargoSaveRequestDTO {

    @NotNull    @NotBlank
    private String descricaoCargo;

    @NotNull
    private BigDecimal salarioBase;




}
