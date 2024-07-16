package org.example;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import static org.hamcrest.Matchers.*;

public class BasicAPI {
    public static void main(String []args) throws InterruptedException {
     //given - all input details
     //when - submit api
     //then - validate the response

        RestAssured.baseURI="https://rahulshettyacademy.com/";
        String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
                .body(payload.AddPlace()).when().post("/maps/api/place/add/json").then().log().all()
                .assertThat().statusCode(200).body("scope",equalTo("APP")).extract().asString();
                //.header("server","Apache/2.4.18 (Ubuntu)");

        System.out.println(response);
        JsonPath js = new JsonPath(response);//for parsing json
        String placeId=js.getString("place_id");
      System.out.println(placeId);

      Thread.sleep(2000);
      //update place
       given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
               .body("{\r\n" +
                       "\"place_id\":\""+placeId+",\r\n" +
                       "\"address\":\"70 Summer walk, USA\",\r\n" +
                       "\"key\":\"qaclick123\"\r\n" +
                        "}").when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));

    }




}
