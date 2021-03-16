#Author: Anderson Barbosa

@release @excluir
Feature: Exclusao de funcionarios
  Como api quero excluir funcionarios da empresa para ao possuirem mais o registo


  Scenario: excluir funcionario por email
			Given que esteja usando o verbo delete para excluir um funcionario
			Then retorna status code 200 da exclusao
			
			
			