package jpaTutorial.jpa.repositories;

import jpaTutorial.jpa.entities.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}