package com.musalasoft.gateways.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class GatewayEntity extends BaseEntity {

    @Column(name="SERIAL_NUMBER", insertable = true, updatable = false)
    private String serialNumber;

    @Column(name="NAME")
    private String name;

    @Column(name="IP")
    private String IP;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name="GATEWAY_ID")
    private Set<PeripheralDeviceEntity> devices;

    @PrePersist
    protected void onCreate() {
        this.setSerialNumber(java.util.UUID.randomUUID().toString());
    }
}
