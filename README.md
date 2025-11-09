 PASSO A PASSO – RODAR O PROJETO EM OUTRO COMPUTADOR
 1) O que precisa estar instalado no outro PC

Antes de qualquer coisa, o PC precisa ter:

1. Java JDK 17 instalado

Baixe (Windows 64 bits):

 Pesquise no Google: “JDK 17 download Oracle”
ou use: Adoptium Eclipse Temurin 17 (também funciona).

Depois de instalar:

Abra o CMD e teste:

java -version


Tem que aparecer algo como:

openjdk version "17.x..."

2. MySQL instalado

Versão recomendada: MySQL 8.0

E você precisa criar o mesmo banco que usa no seu projeto:

Exemplo:

CREATE DATABASE vacinaweb;


Ou o nome que seu projeto usa.



 Configurar o application.properties

No outro PC, abra:

src/main/resources/application.properties


E coloque o usuário e senha do MySQL do OUTRO PC, por exemplo:

spring.datasource.url=jdbc:mysql://localhost:3306/vacinaweb
spring.datasource.username=root
spring.datasource.password=1234


 A senha pode ser diferente entre os PCs.

 Instalar as tabelas no MySQL

Se o seu projeto já usa:

spring.jpa.hibernate.ddl-auto=update


Então o Spring cria tudo sozinho. 

Se não, você deve executar seu SQL manualmente (se quiser te gero um script).
 Rodar o projeto no outro PC

No outro PC:

Abra o IntelliJ ou Eclipse

Vá em:

 File > Open
 Abra a pasta do projeto
 Espere carregar (Maven baixar libs)

Depois basta rodar:

 VacinaWebappApplication.java

E acessar:

 http://localhost:8080


 
 
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
