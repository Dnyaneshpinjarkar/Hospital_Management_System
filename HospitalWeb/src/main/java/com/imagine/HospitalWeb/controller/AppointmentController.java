package com.imagine.HospitalWeb.controller;

import com.imagine.HospitalWeb.models.Appointment;
import com.imagine.HospitalWeb.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController
{
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointments()
    {
        return appointmentService.getAllAppointments();
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment)
    {
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id)
    {
        return appointmentService.getAppointmentById(id);
    }

    @DeleteMapping
    public void deleteAppointment(@PathVariable Long id)
    {
        appointmentService.deleteAppointment(id);
    }

    @PutMapping
    public void UpdateAppointment(@PathVariable Long id, @RequestBody Appointment appointment)
    {
        appointmentService.updateAppointment(id, appointment);
    }
}
