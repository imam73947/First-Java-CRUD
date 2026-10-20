package com.imam.firstjavacrud.repository;

import com.imam.firstjavacrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
