package com.rohit.CRUDBackend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.rohit.CRUDBackend.Entity.Student;
import com.rohit.CRUDBackend.Entity.StudentDTO;
import com.rohit.CRUDBackend.service.StudentService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * StudentController
 */
@RestController
@RequestMapping("/")
public class StudentController {
    final StudentService service;

    StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return service.getStudent(id);
    }

    @GetMapping("/all")
    public List<Student> getAllStudent() {
        return service.getAllStudent();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student s) {
        return service.addStudent(s);
    }

    @PutMapping("/{id}")
    public Student putMethodName(@PathVariable Integer id, @RequestBody Student s) {
        return service.updateStudent(id, s);
    }

    @DeleteMapping("/{id}")
    public boolean removeStudent(@PathVariable int id) {
        return service.deleteStudent(id);
    }

    @PatchMapping("/{id}")
    public Student patchStudent(@PathVariable int id, @RequestBody StudentDTO sdto) {
        return service.patchStudent(id, sdto);
    }

}