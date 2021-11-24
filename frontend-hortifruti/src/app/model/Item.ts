import { Produto } from "./Produto";

export class Item{
    id!: number;
    idPedido?: number;
    idProduto?: number;
    produto!: Produto;
    quantidadeTotal?: number;
    valorTotal?: number;
}