export class Endereco{
    id: number;
    cep: String;
    cidade: String;
    bairro: String;
    estado: String;
    rua: String;
    complemento: String;
    numero: number;

    constructor(id: number, cep: String, cidade: String, bairro: String, 
        estado: String, rua: String, complemento: String, numero: number){
            this. id = id;
            this.cep = cep;
            this.cidade = cidade;
            this.bairro = bairro;
            this.estado = estado;
            this.rua = rua;
            this.complemento = complemento;
            this. numero = numero;
    }
}