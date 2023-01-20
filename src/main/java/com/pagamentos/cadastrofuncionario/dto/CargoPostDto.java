package com.pagamentos.cadastrofuncionario.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Getter
@Setter
public class CargoPostDto {
    private Long idCargo;
    private String descricaoCargo;
    private BigDecimal salarioBase;

}
