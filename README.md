![picture](SKY_APP.png | width=100)

![picture](SKY_APP_detail.png | width=100)

################################################################################################
 
 O app foi implementado seguindo o TDD para arquitetura Clean Code (VIPER).
 
 Comportamento geral:
  - Ao abrir o APP pela primeira vez o sistema irá consumir a API de 12 filmes selecionados;
  - O retorno dessa consulta é uma lista contendo uma thumbnail do poster do filme e o título;
  - Ao clicar em algum filme irá abrir uma tela contendo os detalhes do filme;
  - No momento que o usuário retorna ao aplicativo, a lista atualizará sozinha;
  
################################################################################################
 
 O passo a passo da implementação e a priorização dos itens se deu da seguinte maneira:
 - Primeiro criou-se um novo projeto e foi gerado a base da Activity principal e suas classes da arquitetura VIPER à partir do framework Clean Code Generator para Kotlin previamente instalada no Android Studio;
 - O layout da tela do app foi criado;
 - Criou-se uma classe worker para gerar uma lista de filmes "mockados" para facilitar os testes unitários
 - A medida que cada módulo foi implementado (Na ordem: fragment, interactor, presenter e router) os respectivos testes unitários foram criados também;
 - Foi feita a implementação do acesso à API usando o Retrofit e o tratamento do json para poder extrair as informações relevantes de cada item da lista;
