package com.rohit.CRUDBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.CRUDBackend.Entity.Student;

public interface StudentRepo extends JpaRepository<Student,Integer> {

    
} 