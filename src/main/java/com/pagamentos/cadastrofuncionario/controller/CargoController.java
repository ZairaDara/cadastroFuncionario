package com.pagamentos.cadastrofuncionario.controller;

import com.pagamentos.cadastrofuncionario.dto.CargoPostDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/cargo")
public class CargoController {

    @PostMapping
    public ResponseEntity<?> inserirCargo (@RequestBody CargoPostDto cargo){
        return ResponseEntity.ok().build();
    }


}

