package jpaTutorial.jpa.repositories;

import jpaTutorial.jpa.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}