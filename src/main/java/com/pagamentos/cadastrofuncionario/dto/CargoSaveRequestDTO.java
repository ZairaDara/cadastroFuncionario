package com.pagamentos.cadastrofuncionario.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class CargoSaveRequestDTO {


    private String descricaoCargo;
    private BigDecimal salarioBase;




}
