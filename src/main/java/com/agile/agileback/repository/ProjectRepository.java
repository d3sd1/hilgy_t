package com.agile.agileback.repository;


import com.agile.agileback.model.Investor;
import com.agile.agileback.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}