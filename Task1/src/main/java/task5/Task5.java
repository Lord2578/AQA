//{
//  "name": "John",
//  "age": 30,
//  "isMarried": true,
//  "address": {
//    "city": "New York",
//    "state": "NY"
//  }
//}

//<person>
//  <name>John</name>
//  <age>30</age>
//  <isMarried>true</isMarried>
//  <address>
//    <city>New York</city>
//    <state>NY</state>
//  </address>
//</person>

//The general task for all:
//Serialization-Deserialization:
//a) Make some complex models using your variant.
//b) Make it serializable.
//c) Read JSON from “input.json”
//d) and deserialize it to POJO.
//e) Then change a few fields and save it to “output.json”.
//f) Do the same for XML.
//
//Stream:
//a) Generate 10 random objects using a class from a previous task
//b) Sort it using any two fields using stream.
//c) Filter it by any two fields custom filter.
//d) Collect it to List with *main field(s).
//
//   3. Write a maven command for executing one of your tasks with arguments (number of elements).


package task5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Task5 {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = null;
        try {
            person = objectMapper.readValue(Files.readString(new File("C:\\Users\\Lord\\Desktop\\University\\Fourth Course\\First Term\\AQA\\Task1\\src\\main\\resources\\input.json").toPath()), Person.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(person.toString());
        person.setName("new name");
        person.setAge(25);
        System.out.println(person.toString());
        try {
            objectMapper.writeValue(new File("C:\\Users\\Lord\\Desktop\\University\\Fourth Course\\First Term\\AQA\\Task1\\src\\main\\resources\\output.json"), person);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //xml

        XmlMapper xmlMapper = new XmlMapper();


        try {
            person = xmlMapper.readValue(Files.readString(new File("C:\\Users\\Lord\\Desktop\\University\\Fourth Course\\First Term\\AQA\\Task1\\src\\main\\resources\\input.xml").toPath()), Person.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(person.toString());
        person.setName("new name");
        person.setAge(25);
        System.out.println(person.toString());

        try {
            xmlMapper.writeValue(new File("C:\\Users\\Lord\\Desktop\\University\\Fourth Course\\First Term\\AQA\\Task1\\src\\main\\resources\\output.xml"), person);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
