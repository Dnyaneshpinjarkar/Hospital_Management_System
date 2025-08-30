package com.imagine.HospitalWeb.service;

import com.imagine.HospitalWeb.Repository.PatientRepo;
import com.imagine.HospitalWeb.models.Patient;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class PatientService
{
    @Autowired
    private PatientRepo patientRepo;
    //private static final Logger logger = (Logger) LoggerFactory.getLogger(PatientService.class);
    private Object Optional;

    public List<Patient> getAllPatients()
    {
        try
        {
            return patientRepo.findAll();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public Patient createPatient(Patient patient)
    {
        try
        {
            patientRepo.save(patient);
            return patient;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public Patient getPatientById(Long id)
    {
        try
        {
            Optional<Patient> patient = patientRepo.findById(id);
            return patient.orElse(null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //logger.info("error in massage");
            return null;
        }
    }

    public void updatePatient(Long id, Patient patient)
    {
        try
        {
            Optional<Patient> patientOld = patientRepo.findById(id);
            if (patientOld.isPresent())
            {
                Patient p = patientOld.get();
                p.setName(patient.getName());
                p.setAge(patient.getAge());
                p.setGender(patient.getGender());
                patientRepo.save(p);
            }
            else
            {
               // logger.info("Patient Not found of id : {id}");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void deletePatient(Long id)
    {
        try
        {
            //logger.info("Deleting patient of id : {id}");
            patientRepo.deleteById(id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
