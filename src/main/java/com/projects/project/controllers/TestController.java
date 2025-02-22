package com.projects.project.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/a")
    public String test() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        return "SecurityContextHolder.getContext().getAuthentication().getAuthorities();";
    }
}
