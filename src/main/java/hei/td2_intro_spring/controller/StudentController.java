package hei.td2_intro_spring.controller;

import hei.td2_intro_spring.entity.StudentEntity;
import hei.td2_intro_spring.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getAllStudents(@RequestHeader("Accept") String accept) {
        if(accept.equals("text/plain")){
            return String.join("\n", studentService.getAllStudentsFullName());
        }else {
            return "Format not supported ";
        }
    }


    @PostMapping
    public List<String> createStudents(@RequestBody List<StudentEntity> students) {
        studentService.createStudents(students);

        return studentService.getAllStudentsFullName();
    }
}

