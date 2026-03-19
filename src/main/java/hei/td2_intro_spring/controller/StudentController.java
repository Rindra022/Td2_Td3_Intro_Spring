package hei.td2_intro_spring.controller;

import hei.td2_intro_spring.entity.StudentEntity;
import hei.td2_intro_spring.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAllStudents(@RequestHeader("Accept") String accept) {
        if(accept.equals("text/plain")){
            String allNames = String.join("\n", studentService.getAllStudentsFullName());
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(allNames);
        }else {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body("Format not supported ");
        }
    }


    @PostMapping
    public ResponseEntity<List<String>> createStudents(@RequestBody List<StudentEntity> students) {
        studentService.createStudents(students);

        return ResponseEntity
                .ok(studentService.getAllStudentsFullName());
    }
}

