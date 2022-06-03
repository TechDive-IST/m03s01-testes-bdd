package steps;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CommonSteps extends BaseSteps {

    @Dado("que foi realizado login")
    public void queFoiRealizadoLogin() {
        ObjectNode node = objectMapper.createObjectNode()
                .put("email", "james@kirk.com")
                .put("senha", "1234");
        requestJson = node.toString();
        response = given()
                .contentType(ContentType.JSON)
                .body(requestJson)
                .when().post("/login").then();
        response.statusCode(201);
        token = response.extract().asString();
    }

    @Entao("deve retornar http status code {int}")
    public void deveRetornarHttpStatusCode(Integer status) {
        response.statusCode(status);
    }

    @Entao("response deve conter lista de objetos")
    public void responseDeveConterListaDeObjetos() {
        response.body("$", not(emptyArray()));
    }

}
