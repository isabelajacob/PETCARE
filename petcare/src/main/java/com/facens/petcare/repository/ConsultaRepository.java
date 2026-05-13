package com.facens.petcare.repository;

import com.facens.petcare.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    // Busca conflito de horário do veterinário
    @Query("SELECT c FROM Consulta c WHERE c.veterinario.id = :vetId " +
           "AND c.dataHora = :dataHora AND c.status = 'AGENDADA'")
    List<Consulta> findConflito(Long vetId, LocalDateTime dataHora);

    // Histórico de consultas de um animal
    List<Consulta> findByAnimalId(Long animalId);

    // Consultas de um veterinário
    List<Consulta> findByVeterinarioId(Long veterinarioId);
}