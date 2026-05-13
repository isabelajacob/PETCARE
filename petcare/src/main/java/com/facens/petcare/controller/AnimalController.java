package com.facens.petcare.controller;

import com.facens.petcare.model.Animal;
import com.facens.petcare.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/animais")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;

    @PostMapping("/tutor/{tutorId}")
    public ResponseEntity<?> cadastrar(@RequestBody Animal animal,
                                       @PathVariable Long tutorId) {
        try {
            return ResponseEntity.ok(animalService.cadastrar(animal, tutorId));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Animal> listarTodos() {
        return animalService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(animalService.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/tutor/{tutorId}")
    public List<Animal> buscarPorTutor(@PathVariable Long tutorId) {
        return animalService.buscarPorTutor(tutorId);
    }
}