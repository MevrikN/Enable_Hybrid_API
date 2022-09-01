package RestAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.core.IsNot.not;

public class API {

    int offset = 0;
    int limit = 99;
    int timeStamp =1;
    String publicApiKey="6408f966d878e5c688731d42f4d73d86";
    String hashKey= "9b0f0f5884703730ac0a6cc635c7f780";

    @BeforeClass
    public static void Setup()
    {
        RestAssured.baseURI = "http://gateway.marvel.com/v1/public/characters";
    }

    @Test
    public void baseUrlSuccess(){
        Response response = given()
                .queryParam("ts",timeStamp) // any string
                .queryParam("apikey",publicApiKey ) // public key
                .queryParam("hash", hashKey) // md5 hash
                .queryParam("offset",offset)
                .and()
                .queryParam("limit", limit)
                .when()
                .get()
                .then()
                .extract().response();
        response.getBody().prettyPrint();
    }

    public ValidatableResponse getResponse() {
        ValidatableResponse response = given()
                .queryParam("ts", timeStamp) // any string
                .queryParam("apikey", publicApiKey) // public key
                .queryParam("hash", hashKey) // md5 hash
                .queryParam("offset",offset)
                .and()
                .queryParam("limit", limit)
                .when()
                .get()
                .then();

        return response;
    }

    //Character properties in response
    @Test
    public void verify_character_properties_1(){

        ValidatableResponse response = getResponse();

        String jsonPathExpression = "data.results[0]";
        response.assertThat()
                .body(jsonPathExpression, hasKey("id"))
                .body(jsonPathExpression, hasKey("description"))
                .body(jsonPathExpression, hasKey("modified"))
                .body(jsonPathExpression, hasKey("resourceURI"))
                .body(jsonPathExpression, hasKey("thumbnail"))
                .body(jsonPathExpression, hasKey("stories"))
                .body(jsonPathExpression, hasKey("events"))
                .body(jsonPathExpression, hasKey("urls"));
    }

    //Verify properties
    @Test
    public void verify_character_properties_2_failing(){

        ValidatableResponse response = getResponse();

        String jsonPathExpression = "data.results[0]";

        response.assertThat()
                .body(jsonPathExpression, hasKey("comics"))
                .body(jsonPathExpression, hasKey("name"));

    }

    //Verify negative responses
    @Test
    public void verify_character_properties_Negative(){

        ValidatableResponse response = getResponse();

        String jsonPathExpression = "data.results[0]";

        response.assertThat()
                .body(jsonPathExpression, not(hasKey("comicsAbcd")));
    }


    //verify character
    @Test
    public void verify_character_count() {
        Response response = getResponse().extract().response();

        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not matching");
        String actualID = response.jsonPath().getString("data.results[0].id");

        String expectedId = "1011334";

        Assert.assertEquals(actualID, expectedId, "Id is not matching");

    }

    //Get list of characters id and urls to count comics
    @Test
    public void get_list_of_urls(){
        Response response = getResponse().extract().response();
        Assert.assertEquals(response.getStatusCode(),200,"Status Code is not 200");

        ArrayList<Object> ids = new ArrayList<>();

        for (int a = 0 ; a <= limit-1 ; a++){
            ids.add(response.jsonPath().getJsonObject("data.results["+a+"].id"));

            String actID = response.jsonPath().getString("data.results["+a+"].id");
            System.out.println("-----------------------");
            System.out.println("Character ID: " + actID);
            String nameOfCharacter = response.jsonPath().getString("data.results["+a+"].name");
            System.out.println("Name: " + nameOfCharacter);

            String expID = actID ;

            int expectedCount = response.jsonPath().getInt("data.results["+a+"].comics.available");
            System.out.println("Comics available: "+expectedCount);

            List<Detail> details = response.jsonPath().getList("data.results[" + a + "].urls", Detail.class);
            List <String> urls = new ArrayList<>();

            for (Detail d : details){
                if (d.getUrl().contains(expID)){
                    urls.add(d.getUrl());
                }
            }

            for (String url : urls){
                System.out.println("Url :: " + url);
            }

            System.out.println("Url Available " +urls.size());
        }
        System.out.println("Size of Ids = "+ids.size());

    }

    }

