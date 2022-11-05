package PetStore;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.*;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class PetStore {

    String endpoint = "https://petstore.swagger.io/";
    String resource_available = "v2/pet/findByStatus?status=available";

    public Response petFindByStatus(){

        Response res = RestAssured.when().get(endpoint+resource_available)
                .then().extract().response();
                return res;
    }

    public StubMapping mockResponse() throws IOException {
        String mockResData;
        File file = new File("./src/test/resources/response.json");
        BufferedReader br  = new BufferedReader(new FileReader(file));

        while ((mockResData = br.readLine()) != null)
            System.out.println(mockResData);
        WireMockServer mockServer = new WireMockServer(); //defaults to 8080
        mockServer.start();
        return stubFor(get(urlEqualTo("/test/url/"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(mockResData)));
    }


}
