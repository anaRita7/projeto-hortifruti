import { Produto } from "./Produto";

export class Item{
    id!: number;
    idPedido?: number;
    produto!: Produto;
    quantidadeTotal?: number;
    valorTotal?: number;
    imagem?: String;
}