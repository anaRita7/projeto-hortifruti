export class Produto{
    id: number;
    codigo: number;
    nome: String;
    descricao: String;
    unidadeMedida: String;
    valorUnitario: number;
    status: boolean;

    constructor(id: number, codigo:number, nome:String, descricao: String, 
        unidadeMedida: String, valorUnitario: number, status: boolean){
            this.id = id;
            this.codigo = codigo;
            this.nome = nome;
            this.descricao = descricao;
            this.unidadeMedida = unidadeMedida;
            this.valorUnitario = valorUnitario;
            this.status = status;
    }
}