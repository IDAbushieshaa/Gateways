package com.musalasoft.gateways.repository;

import com.musalasoft.gateways.entity.GatewayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatewayRepository extends JpaRepository<GatewayEntity, Long> {
}
