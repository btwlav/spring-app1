package com.spring.first.controllers;

import com.spring.first.entity.Student;
import com.spring.first.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/")
    public String main(@RequestParam(required = false) String fioFilter, Model model) {
        Iterable<Student> students = studentRepo.findAll();

        if (fioFilter != null && !fioFilter.isEmpty()) {
            students = studentRepo.findByFioContaining(fioFilter);
        } else {
            students = studentRepo.findAll();
        }

        model.addAttribute("students", students);
        model.addAttribute("filter", fioFilter);
        return "main";
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestParam String fio, Map<String, Object> model) {
        if (fio.isEmpty()) {
            fio = "John";
        }
        Student student = new Student(fio);
        studentRepo.save(student);

        Iterable<Student> students = studentRepo.findAll();
        model.put("students", students);
        return "main";
    }

//    @PostMapping("filter")
//    public String filter(@RequestParam String fioFilter, Map<String, Object> model) {
//        Iterable<Student> students;
//
//        if (!fioFilter.isEmpty()) {
//            students = studentRepo.findByFioContaining(fioFilter);
//        } else {
//            students = studentRepo.findAll();
//        }
//        model.put("students", students);
//        return "main";
//    }
}