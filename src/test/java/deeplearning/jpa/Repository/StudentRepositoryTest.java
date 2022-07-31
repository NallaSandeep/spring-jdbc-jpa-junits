package deeplearning.jpa.Repository;

import deeplearning.jpa.entities.Student;
import deeplearning.jpa.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testInsertRecord() {
        Student student = Student.builder().name("Dude").salary(Long.valueOf(1542)).build();
        studentRepository.save(student);
    }

    @Test
    public void testPrintRecords() {
        List<Student> list = studentRepository.findAll();
        System.out.println("Students list: " + list);
    }
}
