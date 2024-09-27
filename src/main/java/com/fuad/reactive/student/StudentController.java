package com.fuad.reactive.student;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping
    public Mono<Student> saveMono(@RequestBody Student student) {
        return service.save(student);
    }

    @GetMapping
    public Flux<Student> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Student> findById(@PathVariable Integer id) {
        return service.findById(id);
    }
    
    
    
}
