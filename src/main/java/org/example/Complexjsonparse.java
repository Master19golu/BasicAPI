package org.example;

import io.restassured.path.json.JsonPath;
import files.payload;

public class Complexjsonparse {
    public static void main(String[] args) {
        JsonPath js = new JsonPath(payload.CoursePrice());
        //Print No of courses returned by API
      int count=  js.getInt("courses.size()");
      System.out.println(count);
      //Print Purchase Amount
        int totalt=js.getInt("dashboard.purchaseAmount");
        System.out.println(totalt);
        //Print Title of the first course
        String name=js.get("courses[0].title");
        System.out.println(name);
        //Print All course titles and their respective Prices
        for ( int i =0; i<count; i++){
            String Coursetitle=js.get("courses["+i+"].title");
            System.out.println(Coursetitle);
        }
        //Print no of copies sold by RPA Course
        for ( int i =0; i<count; i++){
            String Coursetitle=js.get("courses["+i+"].title");
            if (Coursetitle.equalsIgnoreCase("RPA")) {

                //copies sold
                int copies=js.get("courses["+i+"].copies");
                System.out.println(copies);
            }
        }


    }



}
