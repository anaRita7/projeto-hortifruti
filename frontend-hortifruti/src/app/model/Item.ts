import { identifierModuleUrl } from "@angular/compiler";
import { ProdutoService } from "../services/produto.service";
import { Produto } from "./Produto";

export class Item{
    idPedido: number;
    idProduto: number;
    quantidadeTotal: number;
    valorTotal?: number;

    constructor(idPedido: number, idProduto: number,
        quantidadeTotal: number){
            this.idPedido = idPedido;
            this.idProduto = idProduto;
            this.quantidadeTotal = quantidadeTotal;
    }
}