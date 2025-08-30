package com.imagine.HospitalWeb.service;

import com.imagine.HospitalWeb.Repository.DoctorRepo;
import com.imagine.HospitalWeb.models.Doctor;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class DoctorService
{
    @Autowired
    private DoctorRepo doctorRepo;
    //private static final Logger logger = (Logger) LoggerFactory.getLogger(PatientService.class);


    public List<Doctor> getAllDoctors()
    {
        try
        {
            return doctorRepo.findAll();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public Doctor createDoctor(Doctor doctor)
    {
        try
        {
            doctorRepo.save(doctor);
            return doctor;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public Doctor getDoctorById(Long id)
    {
        try
        {
            Optional<Doctor> doctor = doctorRepo.findById(id);
            return doctor.orElse(null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //logger.info("error in massage");

        }
        return null;
    }

    public void updateDoctor(Long id, Doctor doctor)
    {
        try
        {
            Optional<Doctor> doctorOld = doctorRepo.findById(id);
            if (doctorOld.isPresent())
            {
                Doctor d = doctorOld.get();
                d.setName(doctor.getName());
                d.setSpeciality(doctor.getSpeciality());
            }
            else
            {
                //logger.info("error in doctor");
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }

    public void deleteDoctor(Long id)
    {
        try
        {
            doctorRepo.deleteById(id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
