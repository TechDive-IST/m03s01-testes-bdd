#language: pt
@ManterVideos

Funcionalidade: Manter Video

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

  Cenario: Inserir mesmo video
    Dado que foi realizado login
    E que requisicao contem dados para insercao de Video
      | url      | http://www.test.com |
      | assunto  | tecnologia          |
      | usuario  | tiagoamp            |
      | duracao  | 120                 |
    Quando a requisicao de insercao video eh enviada
    Entao deve retornar http status code 409

  Cenario: Apagar video com sucesso
    Dado que foi realizado login
    Quando a requisicao de remover video eh enviada
    Entao deve retornar http status code 204