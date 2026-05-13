package com.facens.petcare.controller;

import com.facens.petcare.model.Vacina;
import com.facens.petcare.service.VacinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/vacinas")
@RequiredArgsConstructor
public class VacinaController {

    private final VacinaService vacinaService;

    @PostMapping("/animal/{animalId}")
    public ResponseEntity<?> registrar(@PathVariable Long animalId,
                                        @RequestBody Vacina vacina) {
        try {
            return ResponseEntity.ok(vacinaService.registrar(animalId, vacina));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/animal/{animalId}")
    public List<Vacina> buscarPorAnimal(@PathVariable Long animalId) {
        return vacinaService.buscarPorAnimal(animalId);
    }
}