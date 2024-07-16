package org.example;


import files.payload;
import io.restassured.path.json.JsonPath;
public class SumValidation {
    public static void main(String[] args) {
        JsonPath js = new JsonPath(payload.CoursePrice());
        //Print No of courses returned by API
        int count = js.getInt("courses.size()");
        for(int i = 0; i < count; i++) {
            int price = js.get("courses[" + i + "].price");
            int copies = js.get("courses[" + i + "].copies");
            int amount = price * copies;
            System.out.println(amount);
        }





    }
}
