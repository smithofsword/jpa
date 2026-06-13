package jpaTutorial.jpa.repositories;

import jpaTutorial.jpa.dto.IPatientInfo;
import jpaTutorial.jpa.entities.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientsRepository extends JpaRepository<Patients, Long> {
    List<IPatientInfo> findAllProjectedBy();
}
