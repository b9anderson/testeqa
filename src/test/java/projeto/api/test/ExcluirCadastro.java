package projeto.api.test;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import projeto.api.pages.Metodos;

public class ExcluirCadastro {

	Metodos metodos = new Metodos();
	Response response;

	public Response deletar(String path) {
		this.response = RestAssured.delete("http://localhost:8080/users/"+ path);
		return response;
	}

	@Given("que esteja usando o verbo delete para excluir um funcionario")
	public void que_esteja_usando_o_verbo_delete_para_excluir_um_funcionario() {

		metodos.cadastrar(33, "Anderson Barbosa", "Halliburton", "excluir.usuario@halliburton.com");
		deletar("excluir.usuario@halliburton.com");
		String bodyResponse = this.response.asString();
		System.out.println(bodyResponse);

	}

	@Then("retorna status code {int} da exclusao")
	public void retorna_status_code_da_exclusao(int code) {

		int statusCode = this.response.getStatusCode();
		assertEquals(code, statusCode);

	}

}
