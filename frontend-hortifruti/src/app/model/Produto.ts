export class Produto{
    codigo: number;
    nome: String;
    descricao: String;
    unidadeMedida: String;
    valorUnitario: number;
    status: boolean;

    constructor(codigo:number, nome:String, descricao: String, 
        unidadeMedida: String, valorUnitario: number, status: boolean){
            this.codigo = codigo;
            this.nome = nome;
            this.descricao = descricao;
            this.unidadeMedida = unidadeMedida;
            this.valorUnitario = valorUnitario;
            this.status = status;
    }
}