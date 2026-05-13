package com.facens.petcare.controller;

import com.facens.petcare.model.Prontuario;
import com.facens.petcare.service.ProntuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/prontuarios")
@RequiredArgsConstructor
public class ProntuarioController {

    private final ProntuarioService prontuarioService;

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Map<String, String> body) {
        try {
            Long consultaId = Long.parseLong(body.get("consultaId"));
            String diagnostico = body.get("diagnostico");
            String tratamento = body.get("tratamento");

            return ResponseEntity.ok(
                prontuarioService.registrar(consultaId, diagnostico, tratamento)
            );
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/animal/{animalId}")
    public List<Prontuario> historicoAnimal(@PathVariable Long animalId) {
        return prontuarioService.buscarHistoricoAnimal(animalId);
    }
}