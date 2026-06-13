package jpaTutorial.jpa.service;

import jakarta.transaction.Transactional;
import jpaTutorial.jpa.entities.Insurance;
import jpaTutorial.jpa.entities.Patients;
import jpaTutorial.jpa.repositories.InsuranceRepository;
import jpaTutorial.jpa.repositories.PatientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientsRepository patientsRepository;

    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patients patient = patientsRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance);

        return insurance;
    }
    public void deletePatient(Long patentId){
        patientsRepository.findById(patentId).orElseThrow();
        patientsRepository.deleteById(patentId);

    }
}
