import { Cliente } from "./Cliente";
import { Endereco } from "./Endereco";

export class Pedido{
    id?: any;
    codigo?: number;
    dataHora?: String;
    cliente!: Cliente;
    endereco!: Endereco;
    situacao?: boolean;
    quantidadeTotal?: number;
    valorTotal!: number;
    desconto!:number;
    formaPagamento?: String;
    valorFinal!: number;
}