package com.br.backendhortifruti.controller;

import com.br.backendhortifruti.model.Endereco;
import com.br.backendhortifruti.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class EnderecoController {

    private EnderecoService enderecoService;


    @GetMapping("")
    public ResponseEntity <List<Endereco>> consultarEnderecos(){
        return new ResponseEntity<>(enderecoService.consultarEnderecos(), HttpStatus.OK);
    }



}
