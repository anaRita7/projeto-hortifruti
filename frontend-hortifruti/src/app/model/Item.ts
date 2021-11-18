import { identifierModuleUrl } from "@angular/compiler";
import { ProdutoService } from "../services/produto.service";
import { Produto } from "./Produto";

export class Item{
    id: number;
    idPedido: number;
    idProduto: number;
    quantidadeTotal: number;
    valorTotal: number;

    constructor(id: number, idPedido: number, idProduto: number,
        quantidadeTotal: number, valorTotal:number){
            this.id = id;
            this.idPedido = idPedido;
            this.idProduto = idProduto;
            this.quantidadeTotal = quantidadeTotal;
            this.valorTotal = valorTotal;
    }
}