package com.br.backendhortifruti.model.repository;

import com.br.backendhortifruti.model.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository <Endereco, Integer> {
}
