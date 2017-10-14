package com.sanji.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author 武继明 [wzslw@163.com]
 * @since 16-11-26 下午12:00
 */
@RestController
public class UserController {
    @GetMapping("/users")
    ResponseEntity getUsers(Principal principal){

        return ResponseEntity.ok(principal);
    }
}
