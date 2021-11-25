use hortfruti;
//clientes

INSERT INTO cliente (tipo, documento, nome, telefone) VALUES 
  ("F","60573721804","Paula Jacobs","3732232122"),
  ("F","62218416625","Iara Pereira","3532222544"),
  ("F","64024381345","Maria Silva","6232214788"),
  ("F","76975072254","Silas Sandoval","6532295552"),
  ("F","54617125360","Graciele Prates","8732230899");
 INSERT INTO cliente (tipo, documento, nome, telefone) VALUES 
  ("F","75403132443","Fernando Maia","8732220577"),
  ("F","65574775883","Denise Vieira","3832212049"),
  ("F","11588686114","Felipe Cardoso","6732221897"),
  ("F","41871731327","Raquel Rocha","1132233133"),
  ("F","04854119563","Caick Stanton","2132212011");
 INSERT INTO cliente (tipo, documento, nome, telefone) VALUES
  ("J","04854119500063","Restaurante da Dona Jura","1132212011"),
  ("J","08745112100005","Restaurante Dois Irmãos","2122215097"),
  ("J","78994521300011","Creche Pedacinho do Céu","1132212055"),
  ("J","03874966100069","Restaurante Popular","3332212011");
 
 
//produtos
  
INSERT INTO produto (codigo, nome, descricao, unidade_medida, valor_unitario, status, imagem)
VALUES
  (45454323,"BANANA PRATA","Embalagem com 500 gramas.","Und",3.29,TRUE,"Gh5YgTerQ1.jpg"),
  (86506849,"ABACATE","Unidade de aproximadamente 150 gramas","Und",2.45,FALSE,"6HJi85GPoi.jpg"),
  (69951181,"LIMÃO TAITI","Embalagem com 400 gramas.","Und",2.19,TRUE,"Lm0766trea.jpg"),
  (97800426,"CEBOLA AMARELA","Aproximadamente 500 gramas.","Kg",3.25,TRUE,"5Yy654Fhha.jpg"),
  (57821763,"ALHO","Embalagem com 200 gramas.","Und",2.75,TRUE,"8I8AL86Gt5A.jpg");
INSERT INTO produto (codigo, nome, descricao, unidade_medida, valor_unitario, status, imagem)
VALUES
  (8005861,"MAÇÃ FUJI","Embalagem de 500 gramas.","Und",5.49,TRUE,"sHy654weQa.jpg"),
  (7568796,"REPOLHO VERDE","Unidade de aproximadamente 100 gramas","Und",1.65,TRUE,"5LK8treasWQ.jpg"),
  (0860057,"KIWI","Embalagem com 150 gramas.","Und",3.79,TRUE,"k3tT551ASa.jpg"),
  (7910878,"PIMENTÃO VERDE","Embalagem com 300 gramas.","Und",4.25,TRUE,"WuA75rd21K.jpg"),
  (8649630,"BRÓCOLIS NINJA","Unidade","Und",5.75,FALSE,"Ki643eFGbb.jpg");
INSERT INTO produto (codigo, nome, descricao, unidade_medida, valor_unitario, status, imagem)
VALUES
  (8878061,"VAGEM","Embalagem de 500 gramas.","Und",4.99,TRUE,"V6BTq121hg.jpg"),
  (7596206,"MELÃO AMARELO","Meia unidade, aproximadamente 200 gramas.","Und",1.65,TRUE,"Mel34IUa5b.jpg"),
  (0869780,"TOMATE ANDREA","Embalagem com 250 gramas.","Und",3.79,TRUE,"Tbv54q2E1q.jpg"),
  (7058918,"MARACUJÁ AZEDO","Embalagem com 300 gramas.","Und",4.25,TRUE,"FV542WwqaP.jpg"),
  (8988640,"ALFACE AMERICANA","Unidade","Und",3.75,TRUE,"yT54QW12e1.jpg");
    
 
//endereco
 
 INSERT INTO endereco (cep, localidade, bairro, uf, logradouro, numero) VALUES
 (39401844, "Montes Claros", "Alcides Rabelo", "Minas Gerais", "Avenida Josefina Rabelo", 275),
 (39402237, "Montes Claros", "Jardim Alvorada", "Minas Gerais", "Rua Baronesa", 55),
 (40296340, "Salvador", "Candeal", "Bahia", "Rua Paulo Afonso", 101),
 (72302703, "Brasilia", "Samambaia", "Distrito Federal", "QR 116 Conjunto 3 Comercio", 1036),
 (88037000, "Florianópolis", "Corrego Grande", "Santa Catarina", "Rua Joao Pio Duarte Silva", 1179);
 

//pedido - YYYY-MM-DD HH:MM:SS

INSERT INTO pedido (codigo, data_hora, id_cliente, id_endereco, situacao, quantidade_total, valor_total, valor_final, desconto, forma_pagamento) values 
(2147483647, NOW(), 1, 3, true, 3, 23.50, 21.15, 0.10, 'dinheiro');