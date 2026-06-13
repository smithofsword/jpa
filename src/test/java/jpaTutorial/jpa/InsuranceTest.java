package jpaTutorial.jpa;

import jpaTutorial.jpa.entities.Appointment;
import jpaTutorial.jpa.entities.Insurance;
import jpaTutorial.jpa.service.AppointmentService;
import jpaTutorial.jpa.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testAssignInsuranceToPatient(){
        Insurance insurance=Insurance.builder()
                .provider("HDFC Ergo")
                .policyNumber("HDFC_2345")
                .validUntil(LocalDate.of(2030,3,2))
                .build();

        var updated=insuranceService.assignInsuranceToPatient(insurance,8L);


        System.out.println(updated);

        insuranceService.deletePatient(8L);


    }

    @Test
    public void testCreateAppointment(){
        Appointment appointment = Appointment.builder().appointmentTime(LocalDateTime.of(2028,11,23,12,23,2)).
                reason("cancer").
                build();


       var updatedAppointment= appointmentService.createANewAppointment(appointment,9L,2L);
       System.out.print(updatedAppointment);

        insuranceService.deletePatient(9L);
    }

}




