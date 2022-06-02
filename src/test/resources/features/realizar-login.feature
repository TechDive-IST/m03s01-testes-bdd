#language: pt
  @RealizarLogin

  Funcionalidade: Realizar Login

    Cenario: Login com credenciais inválidas
      Dado as credenciais inválidas
      Quando requisicao de login enviada
      Entao deve retornar http status code 401

    Cenario: Login com credenciais
      Dado as credenciais
        | email | errado@mail.com |
        | senha | 4321            |
      Quando requisicao de login enviada
      Entao deve retornar http status code 401

    Cenario: Login com sucesso
      Dado as credenciais
        | email | james@kirk.com |
        | senha | 1234           |
      Quando requisicao de login enviada
      Entao deve retornar http status code 201
      E deve conter token no response