import { Produto } from "./Produto";

export class Item{
    id!: number;
    idPedido?: number;
    idProduto?: number;
    quantidadeTotal?: number;
    valorTotal?: number;
}