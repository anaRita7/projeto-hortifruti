import { Cliente } from "./Cliente";
import { Item } from "./Item";
import { Endereco } from "./Endereco";

export class Pedido{
    codigo?: number;
    dataHora?: String;
    idCliente?: Cliente["id"];
    idEndereco?: Endereco["id"];
    situacao?: boolean;
    quantidadeTotal?: number;
    valorTotal!: number;
    desconto!:number;
    formaPagamento?: String;
    valorFinal!: number;
    idItens?: Item["id"][];
}