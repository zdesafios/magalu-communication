# Desafio Magalu
## _José André Henriques_

O projeto em questão foi desenvolvido utilizando as seguintes tecnologias.
- JAVA
- Spring Boot
- Postgres
- Docker
- Docker-compose
- Maven
- Junit 5

## Padrões
Foram implementados alguns padrões de design, tais como Hexagonal, Domain Notification, Repository, Strategy, Factory, Mapper dentre outros

## Features

1. **Criar comunicado**
- [x] A criação do comunicado segue algumas regras(citadas nas proximas features)
- [x] O comunicado é criado com o status **PENDING** e não pode ser modificado para **SENT**, a tentativa de mudar o status para SENT sem ao menos ser salvo, o dominio será notificado com uma viloação de regra
2. **Não pode haver 2 comunicados com o mesmo destinatário, tipo e data de agendamento**
- [x] A verificação de comunicados unicos se dá pelo destanatario, tipo e data de envio
2. **O conteúdo do comunicado está relacionado ao seu tipo**
- [x] Para O tipo SMS o conteúdo deve ser até 160 caracteres em text plain
- [x] Para o tipo WHATSAPP o conteúdo deve ter até 4000 caracteres emtext plain, aceitando anexos e outras mídias.
- [x] Para o tipo EMAIL o conteúdo deve ser adequado ao email, pode ser utilizado HTML, para isso o tamanho pode ser bem maior, chegando a 20.000 caracteres.
- [x] Para o tipo PUSH o conteudo deve ser até 200 caracteres
3. **O destinatário está associado ao tipo**
- [x] Para SMS o destinatário deve ser um número com código do país, código de area e telefone, sem pontos, espaços ou outros caracteres, exceto o +. Exemplo:  _+5581995552710_
- [x] Para WHATSAPP as regras de destinátários do SMS são as mesmas
- [x] Para EMAIL o destinátário deve ser um email válido email@domain.com.br
- [x] para PUSH o destinátario deve ser um UUID na versão 4
4. **Filtrar comunicado**
- [x] O filtro de comunicado é realizado pelos campos: destination, type, when
5. **Cancelar comunicado**
- [x] O comunicado só pode ser cancelado se o mesmo não estiver com o status **SENT**

## Build e Deploy
O Build é gerado pelo mavem, no entanto existe 2 formas de "buildar" e "deployar"

### Fora do container
Para realizar o build/deploy pela IDE, será necessário executar o _docker-compose_ no diretório _local_, esse docker-compose é responsavel de apenas levantar um conteiner do banco de dados(Postgres) e expor a porta 5432.
O banco estando pronto para receber conexões, será possivel executar pela IDE o projeto sem profile.

O projeto que deve ser executado: **web-api**

É NECESSÁRIO JAVA > 11 E MAVEN 3

### Pelo docker
Para realizar o build/deploy pelo Docker é requerido apenas docker e docker-compose na máquina, pois tanto o Java quanto o Maven estão dentro do container.
O postgres não expoe a porta e o profile utilizado pela aplicação(Spring) é "container"

É NECESSÁRIO JAVA NEM MAVEN

## Testes
Ao executar o código abaixo, será criado o relatório de testes, nesse primeiro momento foi testado apenas a camada de domínio
```
    mvn clean test
```
Foi utilizado o Junit 5
Não foi utilizado Mock, pois o repositório(unico componente de chamada externa), foi implementado em LIST, no contexto de teste

## Postman
Foi criado um conjuto de request para facilitar os testes manuais.
Essa coleção pode ser importada no POSTMAN
```
    Magalu.postman_collection.json
```

## Oportunidade de melhorias

Algumas oportunidades de melhorias
-- Teste no componente Web-API, utilizando Mockmvc do Spring
-- Alguns ajustes no dominio, mais especificamente na entidade **Communication** para criação de campos requeridos.