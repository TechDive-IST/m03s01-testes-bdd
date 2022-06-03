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

public class ComentariosSteps extends BaseSteps {

    @Dado("que requisicao contem dados para insercao de Comentario")
    public void queRequisicaoContemDadosParaInsercaoDeComentario(DataTable dados) {
        Map<String, String> map = dados == null ? new HashMap<>() : dados.asMap(String.class, String.class);
        ObjectNode node = objectMapper.createObjectNode();
        map.keySet().stream().forEach(key -> node.put(key, map.get(key)));
        requestJson = node.toString();
    }

    @Quando("a requisicao de insercao comentario eh enviada")
    public void aRequisicaoDeInsercaoComentarioEhEnviada() {
        response = given()
                .headers("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(requestJson)
                .post("/videos/{idVideo}/comentarios", idVideo)
                .then();
    }

    @Quando("a requisicao de remover comentario eh enviada")
    public void aRequisicaoDeRemoverComentarioEhEnviada() {
        response = given()
                .headers("Authorization", "Bearer " + token)
                .delete("/videos/{idVideo}/comentarios/{idComentario}", idVideo, idComentario)
                .then();
    }

    @Entao("response deve conter o id do comentario criado")
    public void responseDeveConterOIdDoComentarioCriado() {
        response.body("$", hasKey("id"));
        response.body("id", notNullValue());
        Integer idComentarioAsInt = response.extract().path("id");
        idComentario = idComentarioAsInt.longValue();
    }

}
