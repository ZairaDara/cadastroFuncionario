package com.pagamentos.cadastrofuncionario.controller;

import com.pagamentos.cadastrofuncionario.dto.CargoPostDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    @PostMapping
    public ResponseEntity<?> inserirCargo (@RequestBody CargoPostDto cargo){
        return ResponseEntity.ok().build();
    }
}

