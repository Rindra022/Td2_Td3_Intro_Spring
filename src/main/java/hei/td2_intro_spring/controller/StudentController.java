package hei.td2_intro_spring.controller;

import hei.td2_intro_spring.entity.StudentEntity;
import hei.td2_intro_spring.service.StudentService;
import org.springframework.http.HttpStatus;
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
        if(accept == null || accept.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Accept header is empty");
        }

        if(!accept.equals("text/plain") && !accept.equals("application/json")){
            return ResponseEntity
                    .status(HttpStatus.NOT_IMPLEMENTED)
                    .body("Accept header not valid");
        }

        try {
            List<StudentEntity> students = studentService.getAllStudents();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(students);

        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error" + e.getMessage());
        }

    }


    @PostMapping
    public ResponseEntity<List<StudentEntity>> createStudents(@RequestBody List<StudentEntity> students) {
        studentService.createStudents(students);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(students);
    }
}

