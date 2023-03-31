package com.example.vaildation.controller;

import com.example.vaildation.dto.User;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/user")
    public ResponseEntity user(@RequestBody User user) {
        System.out.println(user);

        if(user.getPhoneNumber() == "xxx-xxxx-xxxx") {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
        }

        return
    }


}
