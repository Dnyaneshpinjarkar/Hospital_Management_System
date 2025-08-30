package com.imagine.HospitalWeb.Repository;

import com.imagine.HospitalWeb.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepo extends JpaRepository<Bill, Long>
{

}
