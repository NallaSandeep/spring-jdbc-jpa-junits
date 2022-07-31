package deeplearning.jpa.Repository;


import deeplearning.jpa.entities.ClassRoom;
import deeplearning.jpa.repository.ClassRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ClassRepositoryTest {

    @Autowired
    private ClassRepository classRepository;

    @Test
    public void testInsertRecord() {
        ClassRoom classRoom = ClassRoom.builder().name("Class IV").count(14).build();
        classRepository.save(classRoom);
    }

    @Test
    public void testPrintRecords() {
        List<ClassRoom> classRooms = classRepository.findAll();
        System.out.println(classRooms);
    }
}
