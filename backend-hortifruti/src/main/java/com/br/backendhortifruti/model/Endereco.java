package com.br.backendhortifruti.model;

import javax.persistence.*;

@Entity
@Table(name="endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private int id;

    @Column(name="cep")
    private String cep;

    @Column(name="cidade")
    private String cidade;

    @Column(name="estado")
    private String estado;

    @Column(name="rua")
    private String rua;

    @Column(name="complemento")
    private String complemento;

    @Column(name="numero")
    private int numero;

    public Endereco() {
    }

    public Endereco(String cep, String cidade, String estado, String rua, String complemento, int numero) {
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.rua = rua;
        this.complemento = complemento;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
