package com.imagine.HospitalWeb.service;

import com.imagine.HospitalWeb.Repository.AppointmentRepo;
import com.imagine.HospitalWeb.models.Appointment;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AppointmentService
{
    @Autowired
    private AppointmentRepo appointmentRepo;
   // private static final Logger logger = (Logger) LoggerFactory.getLogger(PatientService.class);
    public List<Appointment> getAllAppointments()
    {
        try
        {
            return appointmentRepo.findAll();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }

    public Appointment getAppointmentById(Long id)
    {
        try
        {
            Optional<Appointment> appointment = appointmentRepo.findById(id);
            return appointment.orElse(null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public Appointment createAppointment(Appointment appointment)
    {
        try
        {
            appointmentRepo.save(appointment);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return appointment;
    }

    public void updateAppointment(Long id, Appointment appointment)
    {
        try
        {
            Optional<Appointment> appointmentOld = appointmentRepo.findById(id);
            if (appointmentOld.isPresent())
            {
               Appointment a = appointmentOld.get();
               a.setDate(appointment.getDate());
               a.setDoctorId(appointment.getDoctorId());
               a.setDate(appointment.getDate());
               appointmentRepo.save(a);
            }
            else
            {
                //logger.info("error in appointment");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void deleteAppointment(Long id)
    {
        try
        {
            appointmentRepo.deleteById(id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }


}
