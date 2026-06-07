# 🎓 Sistema de Gestão de Eventos Acadêmicos

Este é o Projeto Prático Integrador desenvolvido para a disciplina de Projeto de Programação. O sistema realiza a gestão de inscrições em eventos, aplicando regras de negócio rigorosas de limite de vagas e validação de datas.

## Tecnologias e Práticas Adotadas

O projeto foi construído utilizando os mais altos padrões de mercado da Engenharia de Software:

* **Linguagem:** Java 17
* **Gerenciador de Dependências:** Maven
* **Arquitetura:** Domain-Driven Design (DDD)
* **Testes Automáticos:** JUnit 5 com Test-Driven Development (TDD)
* **DevOps:** Integração Contínua (CI) com GitHub Actions
* **Banco de Dados:** H2 Database (em memória)
* **Interface Gráfica:** Java Swing (Desktop)

## Estrutura do Projeto (DDD)

O código fonte está organizado na seguinte estrutura arquitetural:

* `domain/`: O coração do software. Contém as Entidades (`Evento`), Value Objects (`Periodo`) e as Interfaces de Repositório, totalmente isoladas de tecnologias externas.
* `application/`: Casos de uso do sistema.
* `infrastructure/`: Implementação do acesso a dados, realizando a persistência real no banco **H2 Database**.
* `presentation/`: Interface visual interativa construída com **Java Swing**.

## Como Executar

1. Clone o repositório para a sua máquina local.
2. Certifique-se de ter o Java JDK 17+ e o Maven instalados.
3. Para rodar a bateria de testes automatizados, execute:
   ```bash
   mvn clean test
4. Para abrir a Interface Gráfica e utilizar o sistema com o banco de dados, execute a classe EventoUI.java localizada no pacote presentation.

   Desenvolvido por Luis Henrique Veras de Araújo.
