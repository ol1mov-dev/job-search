package com.projects.project.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @PreAuthorize("hasAnyAuthority('can:read-post')")
    @GetMapping("a")
    public String a() {
        return "a";
    }
}
