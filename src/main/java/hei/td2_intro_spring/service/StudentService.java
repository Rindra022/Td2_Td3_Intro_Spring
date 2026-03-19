package hei.td2_intro_spring.service;

import hei.td2_intro_spring.entity.StudentEntity;
import hei.td2_intro_spring.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public void createStudents(List<StudentEntity> students) {
        studentRepository.save(students);
    }



}
