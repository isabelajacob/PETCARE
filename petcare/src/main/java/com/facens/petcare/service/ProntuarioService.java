package com.facens.petcare.service;

import com.facens.petcare.model.Consulta;
import com.facens.petcare.model.Prontuario;
import com.facens.petcare.repository.ConsultaRepository;
import com.facens.petcare.repository.ProntuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProntuarioService {

    private final ProntuarioRepository prontuarioRepository;
    private final ConsultaRepository consultaRepository;

    public Prontuario registrar(Long consultaId, String diagnostico, String tratamento) {
        if (diagnostico == null || diagnostico.isBlank()) {
            throw new RuntimeException("Diagnóstico é obrigatório!");
        }

        Consulta consulta = consultaRepository.findById(consultaId)
            .orElseThrow(() -> new RuntimeException("Consulta não encontrada!"));

        consulta.setStatus("REALIZADA");
        consultaRepository.save(consulta);

        Prontuario prontuario = new Prontuario();
        prontuario.setConsulta(consulta);
        prontuario.setDiagnostico(diagnostico);
        prontuario.setTratamento(tratamento);
        prontuario.setData(LocalDate.now());

        return prontuarioRepository.save(prontuario);
    }

    public List<Prontuario> buscarHistoricoAnimal(Long animalId) {
        return prontuarioRepository.findByConsultaAnimalId(animalId);
    }
}