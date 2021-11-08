package com.br.backendhortifruti.controller;

import com.br.backendhortifruti.model.Endereco;
import com.br.backendhortifruti.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api//endereco")
public class EnderecoController {

    private EnderecoService enderecoService;

    @GetMapping("")
    public ResponseEntity <List<Endereco>> consultarEnderecos(){
        return new ResponseEntity<>(enderecoService.consultarEnderecos(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Endereco> incluirEndereco(@RequestBody Endereco endereco){
        return new ResponseEntity<Endereco>(enderecoService.incluirEndereco(endereco), HttpStatus.CREATED);
    }

    @GetMapping("/id")
    public ResponseEntity<Endereco> consultarEndereco(@PathVariable("id") int enderecoId){
        return new ResponseEntity<Endereco>(enderecoService.consultarEndereco(enderecoId), HttpStatus.OK);
    }
}
