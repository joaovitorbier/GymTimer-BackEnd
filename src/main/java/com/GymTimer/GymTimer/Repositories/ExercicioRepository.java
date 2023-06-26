package com.GymTimer.GymTimer.Repositories;

import com.GymTimer.GymTimer.Model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercicioRepository extends JpaRepository<Exercicio,Long> {
}
