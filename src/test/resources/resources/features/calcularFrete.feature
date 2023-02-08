# src/test/resources/features/calcula_frete.feature
# language: pt
Feature: Calcular Frete
Eu, como usuário, quero calcular o frete para um determinado CEP.

Scenario: Calcular Frete para CEP na região Norte
Given que eu informei o CEP "97100000"
When eu realizo a consulta de endereço e cálculo de frete
Then o frete deve ser igual a 20.83

Scenario: Calcular Frete para CEP na região Sul
Given que eu informei o CEP "94000000"
When eu realizo a consulta de endereço e cálculo de frete
Then o frete deve ser igual a 17.30