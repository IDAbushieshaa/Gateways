package com.musalasoft.gateways.repository;

import com.musalasoft.gateways.entity.PeripheralDeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeripheralDeviceRepository extends JpaRepository<PeripheralDeviceEntity, Long> {
}
