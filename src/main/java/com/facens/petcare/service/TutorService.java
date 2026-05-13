package com.facens.petcare.service;

import com.facens.petcare.model.Tutor;
import com.facens.petcare.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorService {

    private final TutorRepository tutorRepository;

    public Tutor cadastrar(Tutor tutor) {
        if (tutor.getNome() == null || tutor.getNome().isBlank()) {
            throw new RuntimeException("Nome do tutor é obrigatório!");
        }
        if (tutor.getEmail() == null || tutor.getEmail().isBlank()) {
            throw new RuntimeException("Email do tutor é obrigatório!");
        }
        return tutorRepository.save(tutor);
    }

    public List<Tutor> listarTodos() {
        return tutorRepository.findAll();
    }

    public Tutor buscarPorId(Long id) {
        return tutorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tutor não encontrado!"));
    }
}