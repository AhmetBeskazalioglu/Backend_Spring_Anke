package com.anke.Backend_Spring_Anke.repository;

import com.anke.Backend_Spring_Anke.entities.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}
