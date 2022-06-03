#language: pt
@ManterVideos

Funcionalidade: Manter Video

  Cenario: Inserir video faltando dados
    Dado que foi realizado login
    E que requisicao contem dados para insercao de Video
      | usuario  | tiagoamp            |
      | duracao  | 120                 |
    Quando a requisicao de insercao video eh enviada
    Entao deve retornar http status code 400

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

  Cenario: Consultar video Por Id
    Quando a requisicao de consulta de video com id eh enviada
    Entao deve retornar http status code 200
    E response deve conter o id do video criado

  Cenario: Consultar videos
    Quando a requisicao de consulta de videos eh enviada
    Entao deve retornar http status code 200
    E response deve conter lista de objetos

  Cenario: Apagar video com sucesso
    Dado que foi realizado login
    Quando a requisicao de remover video eh enviada
    Entao deve retornar http status code 204