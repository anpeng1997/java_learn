package cn.peng.test;

import cn.peng.domain.Person;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

public class JacksonDemoTest {
    @Test
    public void test1() throws IOException {
        Person person = new Person();
        person.setName("pengan");
        person.setAge(123);

        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(person);
        System.out.println(string);
        Person person1 = objectMapper.readValue(string, Person.class);
        System.out.println(person1.getName());
    }
}
