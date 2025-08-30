package com.imagine.HospitalWeb.Repository;


import com.imagine.HospitalWeb.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long>
{

}
