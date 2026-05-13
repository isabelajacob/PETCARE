package com.facens.petcare.repository;

import com.facens.petcare.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByTutorId(Long tutorId);
    List<Animal> findByEspecie(String especie);
}