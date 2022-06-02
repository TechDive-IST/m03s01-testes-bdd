package steps;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;


public class LoginSteps extends BaseSteps {

    @Dado("as credenciais inválidas")
    public void asCredenciaisInválidas() {
        ObjectNode node = objectMapper.createObjectNode()
                .put("email", "errado@gmail.com")
                .put("senha", "4321");
        requestJson = node.toString();
    }

    @Dado("as credenciais")
    public void asCredenciais(DataTable dados) {
        Map<String, String> map = dados != null ? dados.asMap() : new HashMap<>();
        ObjectNode node = objectMapper.createObjectNode();
        Set<String> chaves = map.keySet();
        for (String chave: chaves)
            node.put(chave, map.get(chave));
        requestJson = node.toString();
    }

    @Quando("requisicao de login enviada")
    public void requisicaoDeLoginEnviada() {
        response = given()
                .contentType(ContentType.JSON)
                .body(requestJson)
                .when()
                .post("/login")
                .then();
    }

    @Entao("deve conter token no response")
    public void deveConterTokenNoResponse() {
        String body = response.extract().asString();
        assertNotNull(body);
    }

}
