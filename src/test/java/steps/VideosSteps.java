package steps;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.notNullValue;

public class VideosSteps extends BaseSteps {

    @Dado("que requisicao contem dados para insercao de Video")
    public void queRequisicaoContemDadosParaInsercaoDeVideo(DataTable dados) {
        Map<String, String> map = dados == null ? new HashMap<>() : dados.asMap(String.class, String.class);
        ObjectNode node = objectMapper.createObjectNode();
        map.keySet().stream().forEach(key -> node.put(key, map.get(key)));
        requestJson = node.toString();
    }

    @Quando("a requisicao de insercao video eh enviada")
    public void aRequisicaoDeInsercaoVideoEhEnviada() {
        response = given()
                .headers("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(requestJson)
                .post("/videos")
                .then();
    }

    @Quando("a requisicao de remover video eh enviada")
    public void aRequisicaoDeRemoverVideoEhEnviada() {
        response = given()
                .headers("Authorization", "Bearer " + token)
                .delete("/videos/{id}", idVideo)
                .then();
    }

    @Entao("response deve conter o id do video criado")
    public void responseDeveConterOIdDoVideoCriado() {
        response.body("$", hasKey("id"));
        response.body("id", notNullValue());
        idVideo = response.extract().path("id");
    }

}
