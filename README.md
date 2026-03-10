# ToolsChallange

Implementação de uma API de Pagamentos.  
O desafio proposto consiste em criar uma API de pagamentos onde seja possível:

- Solicitar pagamentos
- Consultar todos os pagamentos
- Consultar pagamentos por ID
- Realizar a solicitação de estorno de um pagamento

---

# Meu entendimento do desafio

Inicialmente entendi que se tratava de um CRUD com alguns detalhes adicionais.  
Durante o desenvolvimento do código me deparei com alguns desafios mais voltados para regras de negócio, como entender para que serviam algumas variáveis e como tratar corretamente seus retornos. Com isso, precisei pensar em algumas soluções para atender aos requisitos do desafio.

## Dúvidas do desafio

### Quais valores preencher nos campos `nsu`, `codigoAutorizacao` e `status`?

**Solução:**

- **Campo `nsu`**: mantive o valor fixo conforme apresentado na imagem do desafio, já que aparentava ser um número sequencial.
- **Campo `codigoAutorizacao`**: como na imagem de resposta o campo apresentava números aleatórios, implementei uma lógica para gerar um número randômico com 9 posições.
- **Campo `status`**: como se tratava de um `Enum` com valores fixos, implementei um retorno aleatório, podendo resultar em uma compra **AUTORIZADA** ou **NEGADA**.

---

### Quais campos aceitariam valores nulos ou vazios?

**Solução:**

Todos os campos da requisição são obrigatórios e não aceitam valores nulos ou vazios, exceto os campos de retorno:

- `nsu`
- `codigoAutorizacao`
- `status`

Durante o desenvolvimento procurei focar em:

- Organização e separação de responsabilidades
- Clareza e legibilidade do código
- Facilidade de manutenção e evolução
- Estrutura que permita testes e extensões futuras

Também considerei boas práticas relacionadas à arquitetura da aplicação, estrutura de camadas e padronização das respostas da API.

---

# Explicação do código

A aplicação foi desenvolvida utilizando **Arquitetura Hexagonal (Ports and Adapters)** para facilitar futuras alterações e separar as responsabilidades entre as camadas da aplicação.

Além disso, foram considerados princípios do **SOLID** e alguns **Design Patterns** para manter o código mais organizado e de fácil manutenção.

Inicialmente todas as variáveis possuem validações para verificar se são nulas ou estão em branco, exceto aquelas que fazem parte da resposta da API, como:

- `nsu`
- `codigoAutorizacao`
- `status`

De forma geral, o projeto é composto pelas seguintes camadas:

---

## Controllers

Responsáveis por receber as requisições da API, validar os dados de entrada e encaminhar para as camadas responsáveis pelo processamento da lógica de negócio.

Controllers implementados:

- `ConsultaController`
- `EstornoController`
- `PagamentoController`

---

## Camada de serviço / Use Cases

Nesta camada está concentrada a lógica principal da aplicação.  
Aqui são executadas as regras de negócio e as decisões necessárias para atender aos requisitos do sistema.

Use cases implementados:

- `BuscarPagamentoPorIdUseCase`
- `BuscarPagamentosUseCase`
- `MascaraCartaoUseCase`
- `SolicitacaoEstornoUseCase`
- `SolicitacaoPagamentoUseCase`

---

## Camada de persistência

Responsável pela comunicação com o banco de dados ou outras fontes de dados.

Essa camada realiza operações como:

- criação
- busca
- atualização

Localizada em : 

-`adapters/out`

---

## Domain / DTOs

Os **Domain Models** representam as estruturas de dados utilizadas internamente pela aplicação.

Os **DTOs (Data Transfer Objects)** são utilizados para transportar dados entre as camadas da aplicação e também entre cliente e servidor.

### Domain

- `Pagamento`
- `Transacao`
- `Descricao`
- `FormaPagamento`

### DTO

- `PagamentoDTO`
- `TransacaoDTO`
- `DescricaoDTO`
- `FormaPagamentoDTO`

---

## Tratamento de exceções

O projeto possui tratamento centralizado de exceções para garantir que erros sejam retornados de forma padronizada pela API.

Isso permite retornar mensagens mais claras ao consumidor da API em casos como:

- erro de validação
- formato de dados inválido
- requisições incorretas

---

# Como usar

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- Java 21 ou superior
- Maven
- Git
- Docker
- Alguma ferramenta para testar APIs (Postman, Insomnia, etc.)


Após clonar o repositório dentro do projeto você vai encontrar uma pasta com o nome de Collection, nela vai ter a collection montada para conseguir chamar os endpoins da API. Antes de iniciar o projeto abra um prompt na pasta de docker-local e insira o comando

```bash
docker-compose up
```

Nessa pasta esta configurado uma imagem do mongoDB para você conseguir salvar os pagamentos.

Após isso você pode iniciar o projeto e chamar os endpoints.

---
