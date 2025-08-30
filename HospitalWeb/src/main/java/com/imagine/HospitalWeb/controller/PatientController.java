package com.imagine.HospitalWeb.controller;


import com.imagine.HospitalWeb.models.Patient;
import com.imagine.HospitalWeb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/patients")
public class PatientController
{
    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients()
    {
        return patientService.getAllPatients();
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient)
    {
        return patientService.createPatient(patient);
    }

    @RequestMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id)
    {
        return patientService.getPatientById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id)
    {
        patientService.deletePatient(id);
    }

    @PutMapping("/{id}")
    public void updatePatient(@PathVariable Long id, @RequestBody Patient patient)
    {
        patientService.updatePatient(id, patient);
    }
}
