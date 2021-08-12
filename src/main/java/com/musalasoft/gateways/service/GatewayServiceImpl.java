package com.musalasoft.gateways.service;

import com.musalasoft.gateways.entity.GatewayEntity;
import com.musalasoft.gateways.entity.PeripheralDeviceEntity;
import com.musalasoft.gateways.model.GatewayModel;
import com.musalasoft.gateways.repository.GatewayRepository;
import com.musalasoft.gateways.repository.PeripheralDeviceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;


@Service
public class GatewayServiceImpl implements GatewayService{

    @Autowired
    private GatewayRepository gatewayRepository;

    @Autowired
    private PeripheralDeviceRepository peripheralDeviceRepository;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public GatewayModel getGateway(long id) {
        Optional<GatewayEntity> gatewayOptional = gatewayRepository.findById(id);
        GatewayModel gateway = new GatewayModel();
        if(gatewayOptional.isPresent()) {
            GatewayEntity retrievedGateway = gatewayOptional.get();
            gateway = mapper.map(retrievedGateway, GatewayModel.class);
        }
        return gateway;
    }

    @Override
    public List<GatewayModel> getAll() {
        List<GatewayEntity> allGateways = gatewayRepository.findAll();
        List<GatewayModel> result = mapper.map(allGateways, List.class);
        return result;
    }

    @Override
    public void addGateway(GatewayModel gateway) {
        GatewayEntity entity = mapper.map(gateway, GatewayEntity.class);
        if(entity.getDevices() != null) {
            for(PeripheralDeviceEntity peripheralDevice : entity.getDevices()) {
                peripheralDeviceRepository.save(peripheralDevice);
            }
        }
        gatewayRepository.save(entity);
    }
}
