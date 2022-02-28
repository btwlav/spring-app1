package com.spring.first.repos;

import com.spring.first.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepo extends CrudRepository<Student, Integer> {
    List<Student> findByFioContaining(String fio);
    Student findStudentById(int id);
}
