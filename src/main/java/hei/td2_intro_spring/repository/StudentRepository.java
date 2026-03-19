package hei.td2_intro_spring.repository;

import hei.td2_intro_spring.entity.StudentEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private final List<StudentEntity> listStudents =  new ArrayList<>();

    public List<StudentEntity> findAll() {
        return listStudents;
    }

    public void save(List<StudentEntity> students) {
        listStudents.addAll(students);
    }
}
