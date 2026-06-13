package jpaTutorial.jpa.repositories;

import jpaTutorial.jpa.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}