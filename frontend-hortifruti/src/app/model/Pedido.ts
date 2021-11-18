import { Item } from "./Item";

export class Pedido{
    codigo: number;
    dataHora: String;
    cliente: Cliente;
    endereco: Endereco;
    situacao: boolean;
    valorTotal: number;
    quantidadeTotal: number;
    desconto: number;
    valorFinal: number;
    formaPagamento: String;
    itens: Item[];

    constructor(codigo: number, dataHora: String, cliente: Cliente, endereco: Endereco,
        situacao: boolean, valorTotal: number, quantidadeTotal: number, desconto: number,
        valorFinal: number, formaPagamento: String, itens: Item[]){
            this.codigo = codigo;
            this.dataHora = dataHora;
            this.cliente = cliente;
            this.endereco = endereco;
            this.situacao = situacao;
            this.valorTotal = valorTotal;
            this.quantidadeTotal = quantidadeTotal;
            this.desconto = desconto;
            this.valorFinal = valorFinal;
            this.formaPagamento = formaPagamento;
            this.itens = itens;           
    }
}