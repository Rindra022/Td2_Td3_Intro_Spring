package hei.td2_intro_spring.controller;

import hei.td2_intro_spring.entity.StudentEntity;
import hei.td2_intro_spring.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping
    public ResponseEntity<List<StudentEntity>> createStudents(@RequestBody List<StudentEntity> students) {
        studentService.createStudents(students);
        return ResponseEntity.ok(studentService.getAllStudents());
    }
}

