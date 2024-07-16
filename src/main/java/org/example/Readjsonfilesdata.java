package org.example;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Readjsonfilesdata {
    public static void main(String[] args) throws IOException {
        RestAssured.baseURI = "https://rahulshettyacademy.com/";
        String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(new String(Files.readAllBytes(Paths.get("D:\\BasicAPI\\BasiCAPI\\addPlace.json")))).when().post("/maps/api/place/add/json").then().log().all()
                .assertThat().statusCode(200).body("scope", equalTo("APP")).extract().asString();
        //.header("server","Apache/2.4.18 (Ubuntu)");

        System.out.println(response);
        JsonPath js = new JsonPath(response);//for parsing json
        String placeId = js.getString("place_id");
        System.out.println(placeId);
    }
}