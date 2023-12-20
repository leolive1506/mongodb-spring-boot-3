# NoSQL e mongoDB
## Problemas resolvidos
**1. incompatibilidade de impedância**
  - relacional cada dados em uma tabela diferente
  - ao busca tem que fazer todo relacionamento pra montar um relatório
  - dados estão armazenado em memoria secundaria (tabela) estão armazenadas de forma diferente na memória do computador (Objetos relacionados)
  - programa que vai mexer com esses dados fica constantemente traduzindo de modelo relacional para objetos em memória
    - transações e junções degradam performace
**2. Grande volume de dados e acessos**
  - escala vertical (pc maior) ou horizontal (cluster ou grids com varios computadores menores)
  - banco de dados relacionais não foram feitso pra executar em cluster / grids
    - fortemente acoplado
## Caracteristicas em comum
- não utilizam modelo relacional
- tem boa execução em cluster
- código aberto
- não esquema pré-definido

## Modelo Principais noSQL
1. orientado a agregados
  - conjunto de objetos relacionados tratados como uma unidade
  - modelo chave e valor(Riak, redis)
  - modelo de documentos(Mongodb, CouchDB)
  - família de colunas(Cassandra, apache HBase)
2. de grafos
  - dados com relacionamento complexos (Neo4j)

# O que é um agregado
- conjunto de objetos relacionados tratados como uma unidade
- um único acessa busca todos dados relacionados
![image](https://gist.github.com/assets/89431704/dcc18ff2-22dc-4928-99ec-5f0136a58414)

# ResponseEntity
- encapsula estrutura necessária para retornar resposta http