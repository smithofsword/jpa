package jpaTutorial.jpa.service;

import jakarta.transaction.Transactional;
import jpaTutorial.jpa.entities.Appointment;
import jpaTutorial.jpa.entities.Doctor;
import jpaTutorial.jpa.entities.Patients;
import jpaTutorial.jpa.repositories.AppointmentRepository;
import jpaTutorial.jpa.repositories.DoctorRepository;
import jpaTutorial.jpa.repositories.PatientsRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientsRepository patientsRepository;

    @Transactional
    public Appointment createANewAppointment(Appointment appointment,Long patientId, Long doctorId){
        Patients patients=patientsRepository.findById(patientId).orElseThrow();
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();

        appointment.setPatients(patients);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);

        return appointment;

    }
}
