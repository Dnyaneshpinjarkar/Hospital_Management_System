package com.imagine.HospitalWeb.service;

import com.imagine.HospitalWeb.Repository.BillRepo;
import com.imagine.HospitalWeb.models.Bill;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BillService
{
    @Autowired
    private BillRepo billRepo;
    //private static final Logger logger = (Logger) LoggerFactory.getLogger(PatientService.class);

    public List<Bill> getAllBill()
    {
        try
        {
            return billRepo.findAll();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public Bill getBillById(Long id)
    {
        try
        {
            Optional<Bill> bill =  billRepo.findById(id);
            return bill.orElse(null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public Bill createBill(Bill bill)
    {
        try
        {
            billRepo.save(bill);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return bill;
    }

    public void updateBill(Long id, Bill bill)
    {
        try
        {
            Optional<Bill> billOld = billRepo.findById(id);
            if (billOld.isPresent())
            {
                Bill b = billOld.get();
                b.setAmount(bill.getAmount());
                b.setPatientId(bill.getPatientId());
                b.setStatus(bill.getStatus());
                billRepo.save(b);
            }
            else
            {
                //logger.info("error in bill");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void deleteBill(Long id)
    {
        try
        {
            billRepo.deleteById(id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
