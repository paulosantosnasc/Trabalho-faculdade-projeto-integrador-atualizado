 PASSO A PASSO – RODAR O PROJETO EM OUTRO COMPUTADOR
.

 Sistema de Monitoramento de Vacinas – README

Este projeto é um sistema simples desenvolvido em Java + Spring Boot + Thymeleaf + MySQL para cadastrar usuários, vacinas, efeitos adversos e um chat básico de interação.

O objetivo é demonstrar:
 Mapeamento de Entidades com JPA
Herança (classe Pessoa → Usuario)
Relacionamentos (OneToMany / ManyToOne)
 Polimorfismo aplicado em classes
Tratamento de exceções
MVC funcionando com Templates
Persistência no MySQL

 1. Requisitos para rodar o projeto

Antes de abrir o sistema, é necessário instalar:

Java 17 ou superior

https://www.oracle.com/java/technologies/downloads/

 MySQL 8.0

Instalar e deixar rodando.

MySQL Workbench

Para importar o arquivo .sql.

 Eclipse ou IntelliJ

Com suporte ao Spring Boot.

 Maven

Eclipse já tem, mas pode ser instalado separado.

 2. Importando o projeto no Eclipse

Abra o Eclipse

Vá em File > Import

Escolha Existing Maven Project

Selecione a pasta do projeto

Clique em Finish

Aguarde o Maven baixar as dependências

 3. Criando o Banco de Dados

Abra o MySQL Workbench

Crie um schema chamado:

vacinaweb


Vá em Server > Data Import

Selecione o arquivo:

 banco_vacinaweb.sql (o arquivo que você vai enviar)

Import total.

 4. Configurar o arquivo application.properties

No caminho:

src/main/resources/application.properties


Verifique se está assim:

spring.datasource.url=jdbc:mysql://localhost:3306/vacinaweb
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect


Se sua senha MySQL for diferente, alterar aqui.

 5. Rodando o Sistema

Abra a classe:

src/main/java/br/com/faesa/monitorweb/vacinawebapp/VacinaWebappApplication.java


Clique com botão direito

Run As > Spring Boot App

 O sistema vai iniciar na porta 8080.

Acesse no navegador:

http://localhost:8080

 6. Estrutura do Projeto
/controller    -> controladores MVC
/model         -> entidades (Usuario, Vacina, EfeitoAdverso, ChatMensagem...)
/repository    -> interfaces JPA
/templates     -> páginas HTML (Thymeleaf)
application.properties -> configuração do banco
pom.xml -> dependências Maven

7. Demonstração dos conceitos exigidos
 Herança

Usuario extends Pessoa
 Polimorfismo

Pessoa tem métodos sobrescritos em Usuario.

Relacionamentos JPA

Usuario → Vacina

Usuario → Efeito Adverso

ChatMensagem → Usuario

Tratamento de Exceções

Implementado nos controllers.

 
 
RODAR NO MAC 




 PASSO 1 — Ver se o Mac já tem Java 17

No Mac, abre o Terminal (⌘ + Espaço → digita "Terminal").

Digite:

java -version


 Se aparecer 17.x, tudo certo.
 Se der erro ou mostrar 1.8/11, você precisa instalar. Eu te ensino:

 Instalar Java 17 no Mac (super simples)

Abra esse site oficial da Oracle:
https://www.oracle.com/java/technologies/downloads/

Baixe:
"macOS x64 Installer" ou "macOS AArch64" (se o Mac for M1 / M2 / M3)

Clique no .dmg → Instalar → Avançar → Avançar → Concluir.

Depois de instalar, teste de novo:

java -version

PASSO 2 — Coloque seu .jar no Mac

Pegue o arquivo:

vacina-webapp-0.0.1-SNAPSHOT.jar

E coloque dentro de uma pasta, tipo:

 Documentos/vacina-app

Deixe assim:

/Users/SEU-NOME/Documents/vacina-app/vacina-webapp-0.0.1-SNAPSHOT.jar

 PASSO 3 — Entrar nessa pasta pelo Terminal

No Terminal digite:

cd ~/Documents/vacina-app


 PASSO 4 — RODAR O SISTEMA

Agora, só rodar:

java -jar vacina-webapp-0.0.1-SNAPSHOT.jar


Aparecerá o Spring Boot iniciando com mensagens verdes, tipo:

Started VacinaWebappApplication in 4.231 seconds


 Quando aparecer isso, seu sistema já está funcionando.

 PASSO 5 — Abrir no navegador

No Mac, abra o Safari/Chrome e acesse:

http://localhost:8080


Se você mudou a porta no application.properties, usa a porta certa.

 SE DER ERRO DO BANCO (MySQL)

Seu jar usa MySQL. No Mac você precisa instalar:

brew install mysql


After installation:

brew services start mysql


A senha padrão do MySQL no Mac é sem senha.

Se quiser mudar o application.properties pra funcionar sem senha, deixa assim:

spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/vacinaweb


Se não tiver o banco criado, cria assim:

mysql -u root


E dentro do console:

CREATE DATABASE vacinaweb;
EXIT;

 Quer que eu gere um arquivo prontos (RUN.command)?

Eu posso criar para você um arquivo que você dá dois cliques e roda sozinho.

Só me diga:

Nome da pasta no Mac
 Nome exato do arquivo jar (acho que é vacina-webapp-0.0.1-SNAPSHOT.jar)
