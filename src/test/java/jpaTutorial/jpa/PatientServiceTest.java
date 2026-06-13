package jpaTutorial.jpa;


import jpaTutorial.jpa.entities.Patients;
import jpaTutorial.jpa.repositories.PatientsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientsRepository patientRepository;

    @Test
    public void testPatient(){


        List<Patients> patientsList= patientRepository.findAll();

        for(Patients p : patientsList){
            System.out.print(p);
        }
    }
}
