import { PedidoForConsult } from "./PedidoForConsult";
import { PedidoId } from "./PedidoId";
import { Produto } from "./Produto";

export class Item{
    id?: any;
    pedido!: PedidoId;
    produto!: Produto;
    quantidadeTotal?: number;
    valorTotal?: number;
    imagem?: String;
}