package com.agile.agileback.repository;


import java.util.List;

import com.agile.agileback.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}