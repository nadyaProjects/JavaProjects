package com.example.object;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ObjectToJson {
    public static void main(String[] a) {

        Person person = new Person();


        person = ObjectToJson.ObjectToJson(person);

        ObjectMapper Obj = new ObjectMapper();

        try {


            String jsonStr = Obj.writeValueAsString(person);


            System.out.println(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Person ObjectToJson(Person person) {

        // Insert the data
        person.setFirstName("Gosho");
        person.setLastName("Petkov");
        person.setAge(25);
        person.setEmailAddress("goshoTest@abv.bg");
        person.setPhoneNumber("0897654356");
        return person;
    }
}
