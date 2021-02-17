package be.ucll.ti.ip.be.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient add(Patient patient) throws ServiceException {
        if (patientRepository.findPatientByEmail(patient.getEmail())!=null) {
            throw new ServiceException("Email already in use");
        }
        return patientRepository.save(patient);
    }

    public Iterable<Patient> getAll() {
        return patientRepository.findAll();
    }

    public Iterable<Patient> getAllAdults() {
        return patientRepository.findAllAdults();
    }

    List<Patient> getAllSortedByName() {
        return patientRepository.findAll(Sort.by("name"));
    }

    public Patient update(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> findUserById(long id) {
        return patientRepository.findById(id);
    }

}
