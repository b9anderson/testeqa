#Author: Anderson Barbosa

@release @consulta
Feature: Consulta de funcionarios
  Como api quero consultar funcionarios para validar se existem na base


		Scenario: consultar lista de funcionarios
			Given que esteja usando o verbo get para consultar todos os funcionarios
			Then retorna status code 200 da consulta
			And valida o tempo de resposta da api em 200 ms
			

		Scenario: consultar funcionario por email
			Given que esteja usando o verbo get para consultar um email
			Then retorna status code 200 da consulta