package com.pagamentos.cadastrofuncionario.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
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
