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

import java.util.List;
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
        //funcionario.setCargo(funcionarioPost.getIdCargo());

        //save
        funcionarioService.save(funcionario);
        FuncionarioResponseDto funcionarioResponse = new FuncionarioResponseDto();
        funcionarioResponse.setIdFuncionario(funcionario.getIdFuncionario());
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

   @DeleteMapping(value = "/{idFuncionario}")
    public ResponseEntity<String> delete(@PathVariable Long idFuncionario){

        Optional<Funcionario> funcionario = funcionarioService.findById(idFuncionario);
        if(funcionario.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        //delete
       funcionarioService.delete(idFuncionario);
        return ResponseEntity.ok().build();
   }

}
