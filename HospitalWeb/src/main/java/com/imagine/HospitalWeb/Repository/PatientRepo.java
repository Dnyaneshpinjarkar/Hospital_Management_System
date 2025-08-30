package com.imagine.HospitalWeb.Repository;

import com.imagine.HospitalWeb.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long>
{

}
