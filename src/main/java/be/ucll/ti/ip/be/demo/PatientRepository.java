package be.ucll.ti.ip.be.demo;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findPatientByEmail(String email);

    List<Patient> findPatientsByAgeGreaterThan(long age);

    @Query("SELECT p FROM Patient p WHERE p.age>18")
    List<Patient> findAllAdults ();

 }
