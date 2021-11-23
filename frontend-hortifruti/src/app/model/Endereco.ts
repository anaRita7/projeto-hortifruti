export class Endereco{
    id!: number;
    cep?: String;
    localidade?: String; // cidade
    bairro?: String;
    uf?: String; // estado
    logradouro?: String; // rua
    complemento?: String;
    numero?: number;
}