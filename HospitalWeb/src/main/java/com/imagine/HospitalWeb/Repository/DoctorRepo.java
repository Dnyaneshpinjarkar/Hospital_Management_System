package com.imagine.HospitalWeb.Repository;

import com.imagine.HospitalWeb.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor, Long>
{

}
