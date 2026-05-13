package com.facens.petcare.service;

import com.facens.petcare.model.Animal;
import com.facens.petcare.model.Vacina;
import com.facens.petcare.repository.AnimalRepository;
import com.facens.petcare.repository.VacinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VacinaService {

    private final VacinaRepository vacinaRepository;
    private final AnimalRepository animalRepository;

    public Vacina registrar(Long animalId, Vacina vacina) {
        if (vacina.getNome() == null || vacina.getNome().isBlank()) {
            throw new RuntimeException("Nome da vacina é obrigatório!");
        }
        if (vacina.getDataAplicacao() == null) {
            throw new RuntimeException("Data de aplicação é obrigatória!");
        }

        Animal animal = animalRepository.findById(animalId)
            .orElseThrow(() -> new RuntimeException("Animal não encontrado!"));

        vacina.setAnimal(animal);
        return vacinaRepository.save(vacina);
    }

    public List<Vacina> buscarPorAnimal(Long animalId) {
        return vacinaRepository.findByAnimalId(animalId);
    }
}