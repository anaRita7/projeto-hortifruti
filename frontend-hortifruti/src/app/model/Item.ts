import { Produto } from "./Produto";

export class Item{
    id: number;
    idPedido: number;
    produto: Produto;
    quantidadeTotal: number;
    valorTotal: number;

    constructor(id: number, idPedido: number, produto: Produto,
        quantidadeTotal: number, valorTotal:number){
            this.id = id;
            this.idPedido = idPedido;
            this.produto = produto;
            this.quantidadeTotal = quantidadeTotal;
            this.valorTotal = valorTotal;
    }
}