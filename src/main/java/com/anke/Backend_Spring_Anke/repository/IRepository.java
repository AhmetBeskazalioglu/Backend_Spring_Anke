package com.anke.Backend_Spring_Anke.repository;

import com.anke.Backend_Spring_Anke.entities.Anke;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepository extends JpaRepository<Anke, Long> {
}
