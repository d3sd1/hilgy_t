package com.agile.agileback.repository;


import com.agile.agileback.model.Investor;
import com.agile.agileback.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestorRepository extends JpaRepository<Investor, Long> {
}