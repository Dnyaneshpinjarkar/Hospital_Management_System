package com.imagine.HospitalWeb.controller;


import com.imagine.HospitalWeb.models.Bill;

import com.imagine.HospitalWeb.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bill")
public class BillController
{
    @Autowired
    private BillService billService;

    @GetMapping
    public List<Bill> getAllBill()
    {
        return billService.getAllBill();
    }

    @PostMapping
    public Bill createBill(@RequestBody Bill bill)
    {
        return billService.createBill(bill);
    }

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id)
    {
        return billService.getBillById(id);
    }

    @DeleteMapping
    public void deleteBill(@PathVariable Long id)
    {
        billService.deleteBill(id);
    }

    @PutMapping
    public void UpdateBill(@PathVariable Long id, @RequestBody Bill bill)
    {
        billService.updateBill(id, bill);
    }

}
