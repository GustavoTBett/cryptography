# Cryptography

<!-- SOBRE O PROJETO -->
## SOBRE O PROJETO

Programa que criptografa utilizando Java, Spring Boot e JPA, para aprendizado. 

Você cria um objeto de banco para ser salvo criptografado, e o programa te o que salvo, já descriptografado. 

Link do desafio: https://github.com/backend-br/desafios/blob/master/cryptography/PROBLEM.md

```
    Exemplo:
    {
        "userDocument": "11119243920",
        "creditCardToken": "localhost:8080",
        "value": "5000"
    }

    Banco:
    {
        "userDocument": "Puo9MvaWKy6uH/NeOeLseg==",
        "creditCardToken": "6v9VCRrO+Idfy1bfGalbvg==",
        "value": "5000"
    }
  
    Retorno:
    {
        "id": 1,
        "userDocument": "11119243920",
        "creditCardToken": "localhost:8080",
        "value": 5000
    }
```

Tecnologias utilizadas:
* Java
* JPA
* Hibernate
* Lombok
* Postgresql
* Junit

<!-- GETTING STARTED -->
## Instalação

### Pré requisitos

* Insomnia/Postman/Google Chrome ( Para testar os endpoints ) 

* Alguma IDE que rode Java como Eclipse, Netbeans, Intellij... 

* Postgresql


### Instalação

1. Pegue o link do repositório https://github.com/GustavoTBett/cryptography.git
2. Clone o repo
   ```sh
   git clone https://github.com/GustavoTBett/cryptography.git
   ```
3. Abra o projeto em sua IDE de prefêrencia

4. Configure o arquivo application.properties alterando o usuario e senha (Utilize o seu usuário e senha do Postgresql), quando o projeto for executado ele se encarregará de criar a tabela e suas colunas no banco de dados

5. Na IDE execute o arquivo CryptographyApplication

6. No insomnia teste os endpoins no localhost:8080

```
    Exemplo de JSON :
    {
        "userDocument": "11119243920",
        "creditCardToken": "localhost:8080",
        "value": "5000"
    }
 ```
