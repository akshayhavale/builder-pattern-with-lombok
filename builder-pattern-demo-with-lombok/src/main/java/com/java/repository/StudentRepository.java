package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
