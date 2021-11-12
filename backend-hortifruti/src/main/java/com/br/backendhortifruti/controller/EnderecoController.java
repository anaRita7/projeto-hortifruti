package com.br.backendhortifruti.controller;

import com.br.backendhortifruti.model.dto.EnderecoDTO;
import com.br.backendhortifruti.model.dto.EnderecoIdDTO;
import com.br.backendhortifruti.model.entity.Endereco;
import com.br.backendhortifruti.model.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {

    private EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService){
        this.enderecoService = enderecoService;
    }

    @GetMapping("")
    public ResponseEntity <List<EnderecoDTO>> consultarEnderecos(){
        List<Endereco> list = enderecoService.consultarEnderecos();
        return new ResponseEntity<>(EnderecoDTO.converterLista(list), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<EnderecoIdDTO> incluirEndereco(@RequestBody Endereco endereco){
    	Endereco enderecoResponse = enderecoService.incluirEndereco(endereco);
        return new ResponseEntity<EnderecoIdDTO>(EnderecoIdDTO.converter(enderecoResponse), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> consultarEndereco(@PathVariable Integer id){
        Endereco enderecoResponse = enderecoService.consultarEndereco(id);
        return new ResponseEntity<EnderecoDTO>(EnderecoDTO.converter(enderecoResponse), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> alterarEndereco(@PathVariable("id") Integer id, @RequestBody Endereco endereco){
    	enderecoService.alterarEndereco(id, endereco);
        return new ResponseEntity<String>("Endereço alterado com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirEndereco(@PathVariable Integer id){
        enderecoService.excluirEndereco(id);
        return new ResponseEntity<String>("Endereço alterado com sucesso!", HttpStatus.OK);
    }
}