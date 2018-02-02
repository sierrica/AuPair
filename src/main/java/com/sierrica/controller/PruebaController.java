package com.sierrica.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
public class PruebaController {

    @RequestMapping("/mod")
    
    @PreAuthorize("hasAuthority('Everyone') || #oauth2.hasScope('email')")
    public String usuario(Principal principal) {
    	return "Usuario: " + principal.getName();
    }
}
