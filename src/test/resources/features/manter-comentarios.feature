#language: pt
@ManterComentarios

Funcionalidade: Manter Comentario

  Cenario: Inserir video com sucesso
    Dado que foi realizado login
    E que requisicao contem dados para insercao de Video
      | url      | http://www.test.com |
      | assunto  | tecnologia          |
      | usuario  | tiagoamp            |
      | duracao  | 120                 |
    Quando a requisicao de insercao video eh enviada
    Entao deve retornar http status code 201
    E response deve conter o id do video criado

  Cenario: Inserir comentario faltando dados
    Dado que foi realizado login
    E que requisicao contem dados para insercao de Comentario
      | naoExistente  | naoExistente            |
    Quando a requisicao de insercao comentario eh enviada
    Entao deve retornar http status code 400

  Cenario: Inserir comentario com sucesso
    Dado que foi realizado login
    E que requisicao contem dados para insercao de Comentario
      | texto      | texto do comentario |
    Quando a requisicao de insercao comentario eh enviada
    Entao deve retornar http status code 201
    E response deve conter o id do comentario criado

  Cenario: Apagar comentario com sucesso
    Dado que foi realizado login
    Quando a requisicao de remover comentario eh enviada
    Entao deve retornar http status code 204

  Cenario: Apagar video com sucesso
    Dado que foi realizado login
    Quando a requisicao de remover video eh enviada
    Entao deve retornar http status code 204