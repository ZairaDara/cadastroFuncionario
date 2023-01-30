package com.pagamentos.cadastrofuncionario.controller;

import com.pagamentos.cadastrofuncionario.dto.FuncionarioPostDto;
import com.pagamentos.cadastrofuncionario.dto.FuncionarioResponseDto;
import com.pagamentos.cadastrofuncionario.entity.Cargo;
import com.pagamentos.cadastrofuncionario.entity.Funcionario;
import com.pagamentos.cadastrofuncionario.repository.CargoRepository;
import com.pagamentos.cadastrofuncionario.repository.FuncionarioRepository;
import com.pagamentos.cadastrofuncionario.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final FuncionarioRepository funcionarioRepository;
    private final CargoRepository cargoRepository;

    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService,
                                 CargoRepository cargoRepository,
                                 FuncionarioRepository funcionarioRepository){ this.funcionarioService = funcionarioService;
        this.cargoRepository = cargoRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    @PostMapping
    public ResponseEntity<FuncionarioResponseDto> save(@RequestBody @Valid FuncionarioPostDto funcionarioPost){

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioPost.getNome());
        funcionario.setEndereco(funcionarioPost.getEndereco());
        funcionario.setBonusSalarial(funcionarioPost.getBonusSalarial());
        funcionario.setDataContratacao(funcionarioPost.getDataContratacao());
        funcionario.setDataNascimento(funcionarioPost.getDataNascimento());

        if (funcionario.getNome().isBlank()){
            FuncionarioResponseDto funcionarioResponse = new FuncionarioResponseDto();
            funcionarioResponse.setMessage("Nome não pode ser em branco!");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(funcionarioResponse);
        }

        if (funcionario.getEndereco().isBlank()){
            FuncionarioResponseDto funcionarioResponse = new FuncionarioResponseDto();
            funcionarioResponse.setMessage("Endereço não pode ser em branco!");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(funcionarioResponse);
        }

        Optional<Cargo> cargo = cargoRepository.findById(funcionarioPost.getIdCargo());
        if (cargo.isEmpty()) throw new IllegalArgumentException("Cargo informado não existe.");

        funcionario.setCargo(cargo.get());

        //save
        funcionarioService.save(funcionario);
        FuncionarioResponseDto funcionarioResponse = new FuncionarioResponseDto();
        funcionarioResponse.setIdFuncionario(funcionario.getIdFuncionario());
        funcionarioResponse.setMessage("Funcionário Incluído com Sucesso");
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioResponse);
    }

   @GetMapping(value = "/{idFuncionario}")
   public ResponseEntity<FuncionarioPostDto> getById(@PathVariable(value = "idFuncionario") Long userID){
       Optional<Funcionario> funcionario = funcionarioService.findById(userID);
       if (funcionario.isPresent()){
           FuncionarioPostDto funcionarioPostDto = new FuncionarioPostDto();
           funcionarioPostDto.setNome(funcionario.get().getNome());
           funcionarioPostDto.setEndereco(funcionario.get().getEndereco());
           funcionarioPostDto.setBonusSalarial(funcionario.get().getBonusSalarial());
           funcionarioPostDto.setIdCargo(funcionario.get().getCargo().getIdCargo());
           funcionarioPostDto.setDataNascimento(funcionario.get().getDataNascimento());
           funcionarioPostDto.setDataContratacao(funcionario.get().getDataContratacao());
           return ResponseEntity.ok(funcionarioPostDto);
       }else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
   }


    @GetMapping(value = "calculoSalario/{idFuncionario}")
    public ResponseEntity<BigDecimal> calculoSalarioById(@PathVariable(value = "idFuncionario") Long userID){
        Optional<Funcionario> funcionario = funcionarioService.findById(userID);
        if (funcionario.isPresent()){
            Cargo cargo = funcionario.get().getCargo();
            BigDecimal salario = funcionario.get().getBonusSalarial().add(cargo.getSalarioBase());

            return ResponseEntity.ok(salario);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
