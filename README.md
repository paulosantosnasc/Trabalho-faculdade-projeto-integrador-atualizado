✅ PASSO A PASSO – RODAR O PROJETO EM OUTRO COMPUTADOR
✅ 1) O que precisa estar instalado no outro PC

Antes de qualquer coisa, o PC precisa ter:

✅ 1. Java JDK 17 instalado

Baixe (Windows 64 bits):

👉 Pesquise no Google: “JDK 17 download Oracle”
ou use: Adoptium Eclipse Temurin 17 (também funciona).

Depois de instalar:

Abra o CMD e teste:

java -version


Tem que aparecer algo como:

openjdk version "17.x..."

✅ 2. MySQL instalado

Versão recomendada: MySQL 8.0

E você precisa criar o mesmo banco que usa no seu projeto:

Exemplo:

CREATE DATABASE vacinaweb;


Ou o nome que seu projeto usa.

✅ 2) Em seguida copie o projeto para o outro PC

Você pode:

✅ enviar por pendrive
✅ zipar a pasta e mandar por whatsapp
✅ colocar no drive e baixar

O importante é que no outro PC você tenha a pasta completa do seu projeto.

✅ 3) Configurar o application.properties

No outro PC, abra:

src/main/resources/application.properties


E coloque o usuário e senha do MySQL do OUTRO PC, por exemplo:

spring.datasource.url=jdbc:mysql://localhost:3306/vacinaweb
spring.datasource.username=root
spring.datasource.password=1234


⚠️ A senha pode ser diferente entre os PCs.

✅ 4) Instalar as tabelas no MySQL

Se o seu projeto já usa:

spring.jpa.hibernate.ddl-auto=update


Então o Spring cria tudo sozinho. ✅

Se não, você deve executar seu SQL manualmente (se quiser te gero um script).

✅ 5) Rodar o projeto no outro PC

No outro PC:

Abra o IntelliJ ou Eclipse

Vá em:

✅ File > Open
✅ Abra a pasta do projeto
✅ Espere carregar (Maven baixar libs)

Depois basta rodar:

➡️ VacinaWebappApplication.java

E acessar:

👉 http://localhost:8080
