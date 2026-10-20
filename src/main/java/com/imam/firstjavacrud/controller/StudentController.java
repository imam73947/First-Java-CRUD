package com.imam.firstjavacrud.controller;

import com.imam.firstjavacrud.model.Student;
import com.imam.firstjavacrud.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", repository.findAll());
        return "students";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        repository.save(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + id));

        model.addAttribute("student", student);
        return "student-form";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}
