package deeplearning.jpa.repository;

import deeplearning.jpa.entities.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassRoom, Long> {
}
