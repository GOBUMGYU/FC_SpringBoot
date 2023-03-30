package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        var objectMapper = new ObjectMapper();

        //object -> text = object mapper get method를 활용
        var user = new User("고범규", 20, "010-1111-2222");
        String text = objectMapper.writeValueAsString(user);
        System.out.println(user);

        //text -> object = default 생성자 필요
        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);

    }

}
