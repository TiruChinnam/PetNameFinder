package StepDefinitions;

import PetStore.PetStore;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;


public class StepDefinitions extends PetStore {

    Response res;
    StubMapping map;
    @Given("I execute GET method")
    public void i_execute_get_method() {
        res = petFindByStatus();
        Assert.assertEquals(res.getStatusCode(), 200);
    }

    @Then("I verify the response")
    public void i_verify_the_response() {
        String[] name = res.getBody().jsonPath().get("name").toString().split(",");

        String[] status = res.getBody().jsonPath().get("status").toString().split(",");
        int flag = 0;
        for(int i=0;i<name.length;i++){
            if(name[i].contains("doggie") && status[i].contains("available")){
                flag = 1;
            }
        }
        Assert.assertEquals(flag, 1);

    }



    @Given("I execute get method with mock")
    public void i_execute_get_method_with_mock() throws IOException {
        map = mockResponse();

    }

    @Then("I verify mock response")
    public void i_verify_mock_response() {
        Assert.assertEquals(map.getResponse().getStatus(), 200);

    }



}
