package projeto.api.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Consultas {

	public Response consulta(String path) {
		Response response = RestAssured.get("http://localhost:8080/" + path);
		return response;
	}

	@Given("que esteja usando o verbo get para consultar todos os funcionarios")
	public void que_esteja_usando_o_verbo_get_para_consultar_todos_os_funcionarios() {
		consulta("users").asString();
	}

	@Then("retorna status code {int} da consulta")
	public void retorna_status_code_da_consulta(int int1) {
		int statusCode = consulta("users").getStatusCode();
		assertEquals(statusCode, 200);
	}

	@Given("que esteja usando o verbo get para consultar um email")
	public void que_esteja_usando_o_verbo_get_para_consultar_um_email() {
		String bodyResponse = consulta("users/Qut@halliburton.com").asString();
		System.out.println(bodyResponse);
	}
	
	@Then("valida o tempo de resposta da api em {int} ms")
	public void valida_o_tempo_de_resposta_da_api_em_ms(int tempo) {
		long time = consulta("users").time();
		System.out.println("Time" + time);
		boolean result = false;
		if (time <= tempo) {
			result = true;
		}
		assertTrue(result);
	}

}
