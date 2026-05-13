package com.facens.petcare.service;

import com.facens.petcare.model.Veterinario;
import com.facens.petcare.repository.VeterinarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    public Veterinario cadastrar(Veterinario veterinario) {
        if (veterinario.getNome() == null || veterinario.getNome().isBlank()) {
            throw new RuntimeException("Nome do veterinário é obrigatório!");
        }
        if (veterinario.getEspecialidade() == null || veterinario.getEspecialidade().isBlank()) {
            throw new RuntimeException("Especialidade do veterinário é obrigatória!");
        }
        return veterinarioRepository.save(veterinario);
    }

    public List<Veterinario> listarTodos() {
        return veterinarioRepository.findAll();
    }

    public Veterinario buscarPorId(Long id) {
        return veterinarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Veterinário não encontrado!"));
    }
}