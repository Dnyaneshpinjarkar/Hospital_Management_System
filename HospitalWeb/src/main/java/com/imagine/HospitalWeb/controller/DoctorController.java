package com.imagine.HospitalWeb.controller;


import com.imagine.HospitalWeb.models.Doctor;
import com.imagine.HospitalWeb.models.Patient;
import com.imagine.HospitalWeb.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/doctors")
public class DoctorController
{
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctor()
    {
        return doctorService.getAllDoctors();
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor)
    {
        return doctorService.createDoctor(doctor);
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id)
    {
        return doctorService.getDoctorById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id)
    {
        doctorService.deleteDoctor(id);
    }

    @PutMapping("/{id}")
    public void UpdateDoctor(@PathVariable Long id, @RequestBody Doctor doctor )
    {
        doctorService.updateDoctor(id, doctor);
    }
}
