package com.musalasoft.gateways;


import com.musalasoft.gateways.entity.GatewayEntity;
import com.musalasoft.gateways.entity.PeripheralDeviceEntity;
import com.musalasoft.gateways.repository.GatewayRepository;
import com.musalasoft.gateways.repository.PeripheralDeviceRepository;
import com.musalasoft.gateways.service.GatewayService;
import com.musalasoft.gateways.service.GatewayServiceImpl;
import com.musalasoft.gateways.service.PeripheralDeviceService;
import com.musalasoft.gateways.service.PeripheralDeviceServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Optional;


@RunWith(SpringRunner.class)
public class GatewayApplicationTest {


    @TestConfiguration
    static class GatewayServiceContextConfiguration {

        @Bean
        public GatewayService gatewayService() {
            return new GatewayServiceImpl();
        }

        @Bean
        public PeripheralDeviceService peripheralDeviceService() {
            return new PeripheralDeviceServiceImpl();
        }

    }


    @Autowired
    GatewayService gatewayService;

    @Autowired
    PeripheralDeviceService peripheralDeviceService;

    @MockBean
    GatewayRepository gatewayRepository;

    @MockBean
    PeripheralDeviceRepository peripheralDeviceRepository;

    private List<GatewayEntity> getAllGateways() {
        List<GatewayEntity> gatewayEntities = new ArrayList<>();
        GatewayEntity gw1 = new GatewayEntity();
        gw1.setId(1L);
        gw1.setName("GW-1");
        gw1.setIP("10.10.10.10");

        GatewayEntity gw2 = new GatewayEntity();
        gw2.setId(2L);
        gw2.setName("GW-2");
        gw2.setIP("11.11.11.11");

        gatewayEntities.add(gw1);
        gatewayEntities.add(gw2);

        return gatewayEntities;
    }

    private List<PeripheralDeviceEntity> getAllPeripheralDevices() {
        List<PeripheralDeviceEntity> allPeripheralDevices = new ArrayList<>();

        PeripheralDeviceEntity pd1 = new PeripheralDeviceEntity();
        pd1.setVendor("IBM");
        pd1.setOnline(true);

        PeripheralDeviceEntity pd2 = new PeripheralDeviceEntity();
        pd2.setVendor("Apple");
        pd2.setOnline(true);

        PeripheralDeviceEntity pd3 = new PeripheralDeviceEntity();
        pd3.setVendor("Google");
        pd3.setOnline(true);

        allPeripheralDevices.add(pd1);
        allPeripheralDevices.add(pd2);
        allPeripheralDevices.add(pd3);

        return allPeripheralDevices;
    }

    private Optional<GatewayEntity> getGatewayEntityOptional(long id) {
        GatewayEntity gw2 = new GatewayEntity();
        gw2.setId(id);
        gw2.setName("GW-2");
        gw2.setIP("11.11.11.11");

        return Optional.of(gw2);
    }

    @Before
    public void setup() {

        Mockito.when(gatewayRepository.findAll()).thenReturn(getAllGateways());
        Mockito.when(peripheralDeviceRepository.findAll()).thenReturn(getAllPeripheralDevices());
        Mockito.when(gatewayRepository.findById(getGatewayEntityOptional(2L).get().getId())).thenReturn(getGatewayEntityOptional(2L));
    }

    @Test
    public void getAllGatewaysTest() {
        assert(gatewayService.getAll().size() == 2);
    }

    @Test
    public void getGatewayById() {
        assert(gatewayService.getGateway(2).getId() == 2);
    }

    @Test
    public void getAllPeripheralDevicesTest() {
        assert(peripheralDeviceService.getAll().size() == 3);
    }
}
