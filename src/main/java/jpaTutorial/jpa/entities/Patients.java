package jpaTutorial.jpa.entities;

import jakarta.persistence.*;
import jpaTutorial.jpa.type.BloodGroupType;
import lombok.*;
import org.hibernate.action.internal.OrphanRemovalAction;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString

public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(unique = true)
    private String email;

    private String gender;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "blood_group")
    private BloodGroupType bloodGroup;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="patient_insurance",unique = true )
    private Insurance insurance;

    @OneToMany(mappedBy = "patients",cascade=CascadeType.ALL)
    private Set<Appointment> appointmentSet=new HashSet<>();
}
