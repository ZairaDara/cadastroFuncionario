package com.pagamentos.cadastrofuncionario.controller;

import com.pagamentos.cadastrofuncionario.dto.FuncionarioPostDto;
import com.pagamentos.cadastrofuncionario.entity.Funcionario;
import com.pagamentos.cadastrofuncionario.service.FuncionarioService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.InjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {


    @PostMapping
    public ResponseEntity<?> inserirFuncionario (@RequestBody FuncionarioPostDto funcionario){

        return ResponseEntity.ok().build();
    }

   // @GetMapping(value = "/{idFuncionario}")
   // public FuncionarioPostDto getById()

}
