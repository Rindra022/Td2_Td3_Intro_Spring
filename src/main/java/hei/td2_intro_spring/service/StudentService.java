package hei.td2_intro_spring.service;

import hei.td2_intro_spring.entity.StudentEntity;
import hei.td2_intro_spring.repository.StudentRepository;
import hei.td2_intro_spring.validator.StudentValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentValidator studentValidator;

    public StudentService(StudentRepository studentRepository, StudentValidator studentValidator) {
        this.studentRepository = studentRepository;
        this.studentValidator = studentValidator;
    }

    public List<String> getAllStudentsFullName() {
        return studentRepository.findAll().stream()
                .map(s -> s.getFirstName() + " " + s.getLastName())
                .toList();
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public String getAllStudentsAsText(){
        return studentRepository.findAll().stream()
                .map(s -> String.join(" ",
                        s.getReference(),
                        s.getFirstName(),
                        s.getLastName()
                ))
                .collect(Collectors.joining("\n"));

    }

    public void createStudents(List<StudentEntity> students) {
        studentValidator.validate(students);
        studentRepository.save(students);
    }

}
