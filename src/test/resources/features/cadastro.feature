#Author: Anderson Barbosa

@release @cadastro
Feature: Cadastro de funcionarios
  Como api quero castrar novos funcionarios na empresa para ter o registo


  	Scenario Outline: cadastrar usuario com sucesso
	    Given que esteja usando o verbo post para cadastrar um funcionario com <idade> anos
	    Then retorna status code <valor>
	    And retorna responseBody <mensagem>
    
    Examples:
    
				 |idade| valor|mensagem																						 				|
				 |14   | 200  |"{\"msg\":\"User inserted\",\"status\":\"success\"}"				|
				 |13   | 500  |"Child work are not accepted\",\"status\":\"error\"}"   	  |
				
		
		Scenario: cadastrar com nome em branco
			Given que esteja usando o verbo post para cadastrar sem informar o nome
			Then retorna status code 500
			And retorna responseBody "name is empty\",\"status\":\"error\"}"
			

			Scenario: cadastrar usuario cadastrado
			Given que esteja usando o verbo post para cadastrar um usuario cadastrado
			Then retorna status code de erro 200
			And retorna responseBody "User already exists\",\"status\":\"error\"}"
			
			
			
