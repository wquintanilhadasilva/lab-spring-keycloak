package com.keycloack.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/lab")
public class LabResource {

    @GetMapping
    public ResponseEntity<Void> security() {
        return ResponseEntity.ok().build();
    }
}
