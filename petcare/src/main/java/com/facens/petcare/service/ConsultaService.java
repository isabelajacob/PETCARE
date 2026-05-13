package com.facens.petcare.service;

import com.facens.petcare.model.Animal;
import com.facens.petcare.model.Consulta;
import com.facens.petcare.model.Veterinario;
import com.facens.petcare.repository.AnimalRepository;
import com.facens.petcare.repository.ConsultaRepository;
import com.facens.petcare.repository.VeterinarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final AnimalRepository animalRepository;
    private final VeterinarioRepository veterinarioRepository;

    public Consulta agendar(Long animalId, Long vetId, LocalDateTime dataHora, String motivo) {

        // REGRA 1: verificar conflito de agenda
        List<Consulta> conflitos = consultaRepository.findConflito(vetId, dataHora);
        if (!conflitos.isEmpty()) {
            throw new RuntimeException(
                "Veterinário já possui consulta agendada nesse horário!"
            );
        }

        // REGRA 2: veterinário atende apenas sua especialidade
        Animal animal = animalRepository.findById(animalId)
            .orElseThrow(() -> new RuntimeException("Animal não encontrado!"));

        Veterinario vet = veterinarioRepository.findById(vetId)
            .orElseThrow(() -> new RuntimeException("Veterinário não encontrado!"));

        if (!vet.getEspecialidade().equalsIgnoreCase(animal.getEspecie())) {
            throw new RuntimeException(
                "Veterinário especializado em " + vet.getEspecialidade() +
                " não pode atender " + animal.getEspecie() + "!"
            );
        }

        // Tudo ok, agenda a consulta
        Consulta consulta = new Consulta();
        consulta.setAnimal(animal);
        consulta.setVeterinario(vet);
        consulta.setDataHora(dataHora);
        consulta.setStatus("AGENDADA");
        consulta.setMotivoConsulta(motivo);

        return consultaRepository.save(consulta);
    }

    public List<Consulta> buscarHistorico(Long animalId) {
        return consultaRepository.findByAnimalId(animalId);
    }

    public List<Consulta> buscarPorVeterinario(Long vetId) {
        return consultaRepository.findByVeterinarioId(vetId);
    }
}