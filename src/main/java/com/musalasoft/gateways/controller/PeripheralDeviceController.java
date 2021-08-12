package com.musalasoft.gateways.controller;

import com.musalasoft.gateways.model.PeripheralDeviceModel;
import com.musalasoft.gateways.service.PeripheralDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("peripheral-devices")
public class PeripheralDeviceController {

    @Autowired
    private PeripheralDeviceService peripheralDeviceService;

    @GetMapping("/retrieve-all")
    public List<PeripheralDeviceModel> getAll() {
        return peripheralDeviceService.getAll();
    }

}
