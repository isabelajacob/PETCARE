package com.facens.petcare.service;

import com.facens.petcare.model.Animal;
import com.facens.petcare.model.Tutor;
import com.facens.petcare.repository.AnimalRepository;
import com.facens.petcare.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final TutorRepository tutorRepository;

    public Animal cadastrar(Animal animal, Long tutorId) {
        if (animal.getNome() == null || animal.getNome().isBlank()) {
            throw new RuntimeException("Nome do animal é obrigatório!");
        }
        if (animal.getEspecie() == null || animal.getEspecie().isBlank()) {
            throw new RuntimeException("Espécie do animal é obrigatória!");
        }

        Tutor tutor = tutorRepository.findById(tutorId)
            .orElseThrow(() -> new RuntimeException("Tutor não encontrado!"));

        animal.setTutor(tutor);
        return animalRepository.save(animal);
    }

    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }

    public List<Animal> buscarPorTutor(Long tutorId) {
        return animalRepository.findByTutorId(tutorId);
    }

    public Animal buscarPorId(Long id) {
        return animalRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Animal não encontrado!"));
    }
}