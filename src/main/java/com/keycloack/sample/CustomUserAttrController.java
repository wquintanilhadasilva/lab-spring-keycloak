package com.keycloack.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping(value = "/security")
public class CustomUserAttrController {

    @RolesAllowed("user")
    @GetMapping(path = "/users")
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("Hello User");
    }

    @RolesAllowed("admin")
    @GetMapping(path = "/admin")
    public ResponseEntity<String> getAdmin() {
        return ResponseEntity.ok("Hello Admin");
    }

    @RolesAllowed("all-use")
    @GetMapping(path = "/all-use")
    public ResponseEntity<String> getAllUser() {
        return ResponseEntity.ok("Hello All User");
    }

    @GetMapping
    public ResponseEntity<Void> security() {
        return ResponseEntity.ok().build();
    }

    /**
     * endpoint sem nenhuma validação de role
     */
    @GetMapping
    public ResponseEntity<Void> isAuthenticated() {
        return ResponseEntity.ok().build();
    }

    /**
     * endpoint onde o usuario tem que ter a role user
     */
    @GetMapping(value = "/has-role")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<Void> isUser() {
        return ResponseEntity.ok().build();
    }

    /**
     * endpoint onde o usuario tem que ter a role admin
     */
    @GetMapping(value = "/is-admin")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> isAdmin() {
        return ResponseEntity.ok().build();
    }

}
