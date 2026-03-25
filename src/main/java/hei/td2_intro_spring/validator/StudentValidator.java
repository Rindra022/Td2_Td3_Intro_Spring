package hei.td2_intro_spring.validator;

import hei.td2_intro_spring.entity.StudentEntity;
import hei.td2_intro_spring.exception.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentValidator {
    public void validate(List<StudentEntity> students) {
        for (StudentEntity student : students) {
            if(student.getReference() == null || student.getReference().isBlank()){
                throw new BadRequestException("Reference cannot be null");
            }
            if(student.getLastName() == null || student.getLastName().isBlank()){
                throw new BadRequestException("Last name cannot be null");
            }
            if(student.getFirstName() == null || student.getFirstName().isBlank()){
                throw new BadRequestException("First name cannot be null");
            }
        }
    }
}
