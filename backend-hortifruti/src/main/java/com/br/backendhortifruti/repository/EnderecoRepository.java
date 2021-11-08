package com.br.backendhortifruti.repository;

import com.br.backendhortifruti.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository <Endereco, Integer> {
}
