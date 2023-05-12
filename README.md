# Scalc, A calculadora simples

Uma calculadora web com as operações de adição e subtração.


## Tech Stack

* Java 17
* Spring MVC
* Thymeleaf
* Gradle

## Decisões de implementação

Pode se ver que as operações são feitas diretamente no controller, quebrando o SRP (Princípio da responsabilidade única). Devido a simplicidade da operação, não acreditamos que os problemas que o SRP busca mitigar não irão impactar o código.

## Considerações futuras

A UI poderia ser alterada para gerar uma tela mais agradável ao olho. Além disso operações extras (multiplicação e divisão) podem ser adicionas.
