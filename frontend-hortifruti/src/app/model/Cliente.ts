export class Cliente{
    id: number;
	nome: String;
	tipo: String;
	documento: String;
	telefone: String;    

    constructor(id: number, nome: String, tipo: String,
        documento: String, telefone: String){
            this.id = id;
            this.nome = nome;
            this.tipo = tipo;
            this.documento = documento;
            this.telefone = telefone;
    }
}