package projeto.api.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.hamcrest.core.StringContains;
import org.json.simple.JSONObject;
import org.junit.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import projeto.api.pages.Metodos;
import projeto.api.utils.RestUtils;

public class Cadastro {

	Metodos metodos = new Metodos();
	RestUtils restUtils = new RestUtils();
	Response response;
	String nome = restUtils.getNome();
	String company = restUtils.getCompany();
	String email = restUtils.getEmail();

	@Given("que esteja usando o verbo post para cadastrar um funcionario com {int} anos")
	public void que_esteja_usando_o_verbo_post_para_cadastrar_um_funcionario_com_anos(int idade) {
		this.response = metodos.cadastrar(idade, this.nome, this.company, this.email);
	}

	@Then("retorna status code {int}")
	public void retorna_status_code(int code) {
		assertEquals(code, response.getStatusCode());
	}

	@Then("retorna responseBody {string}")
	public void retorna_response_body(String retorno) {
		String bodyResponse = this.response.asString();
		assertThat(bodyResponse, StringContains.containsString(retorno));
	}

	@Given("que esteja usando o verbo post para cadastrar sem informar o nome")
	public void que_esteja_usando_o_verbo_post_para_cadastrar_sem_informar_o_nome() {
		this.response = metodos.cadastrar(14, null, this.company, this.email);
	}

	@Given("que esteja usando o verbo post para cadastrar um usuario cadastrado")
	public void que_esteja_usando_o_verbo_post_para_cadastrar_um_usuario_cadastrado() {
		String email = restUtils.getEmail();
		this.response = metodos.cadastrar(14, this.nome, this.company, email);
		this.response = metodos.cadastrar(14, this.nome, this.company, email);
	}

	@Then("retorna status code de erro {int}")
	public void retorna_status_code_de_erro(int code) {
		assertEquals(code, response.getStatusCode());
	}

}
