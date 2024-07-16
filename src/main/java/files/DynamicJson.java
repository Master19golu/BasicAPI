package files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {

@Test
 public void addBox(){
    RestAssured.baseURI="http://216.10.245.166";
    String response=given().header("Content-Type","application/json").body(payload.AddBook("asds","6464"))
            .when().post("Library/Addbook.php")
            .then().assertThat().statusCode(200)
            .extract().response().asString();
    System.out.println(response);
    JsonPath js = new JsonPath(response);//for parsing json
    String placeId=js.get("ID");
    System.out.println(placeId);

    }

   @Test(dataProvider = "booksdata")
   public void addBoxDataprpvider(String isbn , String aisle){
      RestAssured.baseURI="http://216.10.245.166";
      String response=given().header("Content-Type","application/json").body(payload.AddBook(isbn, aisle))
              .when().post("Library/Addbook.php")
              .then().assertThat().statusCode(200)
              .extract().response().asString();
      System.out.println(response);
      JsonPath js = new JsonPath(response);//for parsing json
      String placeId=js.get("ID");
      System.out.println(placeId);

   }

   @DataProvider(name="booksdata")
 public Object[][] getData(){
    return new Object[][] {{"jity","9999"},{"rty","6789"},{"rtg","9880"},{"gggj","6778"}};
 }


}
