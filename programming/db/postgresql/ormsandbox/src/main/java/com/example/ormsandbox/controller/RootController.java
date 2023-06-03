package com.example.ormsandbox.controller;

import com.example.ormsandbox.DTO.RootDTO;
import com.example.ormsandbox.Entity.Root;
import com.example.ormsandbox.service.root.IRootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value="/api/root")
public class RootController {

    @Autowired
    IRootService service;

    @GetMapping(value="/{id}")
    public ResponseEntity<RootDTO> findById(@PathVariable(name="id") int id) {
        RootDTO rootDTO = service.getRoot(id);
        return ResponseEntity.ok(rootDTO);
    }

    @PostMapping(value="/")
    public boolean insertRoot(@RequestBody RootDTO rootDTO) {
        return service.insertRoot(rootDTO);
    }
}
