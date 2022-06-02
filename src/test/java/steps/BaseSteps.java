package steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.ValidatableResponse;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class BaseSteps {

    static {
        baseURI = "http://localhost";
        port = 8080;
        basePath = "/m03s01-1.0-SNAPSHOT/api";
    }

    protected static ObjectMapper objectMapper = new ObjectMapper();
    protected static String requestJson = null;
    protected static Map<String, String> headers = new HashMap<>();
    protected static Map<String, String> parametrosRequest = new HashMap<>();
    protected static String token = null;
    protected static ValidatableResponse response;
    protected static String idVideo;

}
