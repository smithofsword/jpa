package jpaTutorial.jpa.controller;

import jpaTutorial.jpa.dto.IPatientInfo;
import jpaTutorial.jpa.repositories.PatientsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientsRepository patientsRepository;

    public PatientController(PatientsRepository patientsRepository) {
        this.patientsRepository = patientsRepository;
    }

    @GetMapping
    public List<PatientInfoResponse> getPatients() {
        return patientsRepository.findAllProjectedBy()
                .stream()
                .map(PatientInfoResponse::from)
                .toList();
    }

    public record PatientInfoResponse(Long id, String name, String email) {
        private static PatientInfoResponse from(IPatientInfo patientInfo) {
            return new PatientInfoResponse(
                    patientInfo.getId(),
                    patientInfo.getName(),
                    patientInfo.getEmail()
            );
        }
    }
}
