package com.rohit.CRUDBackend.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rohit.CRUDBackend.Entity.Student;
import com.rohit.CRUDBackend.Entity.StudentDTO;
import com.rohit.CRUDBackend.repository.StudentRepo;

@Component
public class StudentService {
    final StudentRepo repo;

    StudentService(StudentRepo repo) {
        this.repo = repo;
    }

    public Student getStudent(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<Student> getAllStudent() {
        return repo.findAll();
    }

    public Student addStudent(Student s) {
        return repo.save(s);
    }

    public Student updateStudent(int id, Student s) {
        return repo.findById(id).map(reg -> {
            reg.setName(s.getName());
            reg.setMarks(s.getMarks());
            return repo.save(reg);
        }).orElse(null);
    }

    public Student patchStudent(int id, StudentDTO dto) {
        return repo.findById(id).map(s -> {
            if (dto.getName() != null) {
                s.setName(dto.getName());
            }
            if (dto.getMarks() != null) {
                s.setMarks(dto.getMarks());
            }
            return repo.save(s);
        }).orElse(null);
    }

    public Boolean deleteStudent(int id) {
        Boolean res = false;
        if (repo.existsById(id)) {
            res = true;
        }
        if (res) {
            repo.deleteById(id);
        }
        return res;
    }

}
