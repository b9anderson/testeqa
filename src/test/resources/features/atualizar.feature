#Author: Anderson Barbosa

@release @atualizar
Feature: Atualizar de funcionarios
  Como api quero atualizar os dados dos funcionarios da empresa para manter atualizados


  Scenario: Atualizar funcionario por email
			Given que esteja usando o verbo put para atualizar um funcionario
			Then retorna status code 200 da atualizacao
			
			
			