package com.musalasoft.gateways.service;

import com.musalasoft.gateways.entity.PeripheralDeviceEntity;
import com.musalasoft.gateways.model.PeripheralDeviceModel;
import com.musalasoft.gateways.repository.PeripheralDeviceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeripheralDeviceServiceImpl implements PeripheralDeviceService{

    @Autowired
    private PeripheralDeviceRepository peripheralDeviceRepository;

    private final ModelMapper mapper = new ModelMapper();

    public List<PeripheralDeviceModel> getAll() {
        List<PeripheralDeviceEntity> peripheralDeviceEntities = peripheralDeviceRepository.findAll();
        return mapper.map(peripheralDeviceEntities, List.class);
    }
}
