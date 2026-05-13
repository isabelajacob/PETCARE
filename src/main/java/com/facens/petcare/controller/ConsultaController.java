package com.facens.petcare.controller;

import com.facens.petcare.model.Consulta;
import com.facens.petcare.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<?> agendar(@RequestBody Map<String, String> body) {
        try {
            Long animalId = Long.parseLong(body.get("animalId"));
            Long vetId = Long.parseLong(body.get("vetId"));
            LocalDateTime dataHora = LocalDateTime.parse(body.get("dataHora"));
            String motivo = body.get("motivo");

            return ResponseEntity.ok(
                consultaService.agendar(animalId, vetId, dataHora, motivo)
            );
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/animal/{animalId}")
    public List<Consulta> historicoAnimal(@PathVariable Long animalId) {
        return consultaService.buscarHistorico(animalId);
    }

    @GetMapping("/veterinario/{vetId}")
    public List<Consulta> consultasPorVet(@PathVariable Long vetId) {
        return consultaService.buscarPorVeterinario(vetId);
    }
}