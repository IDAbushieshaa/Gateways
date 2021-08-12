package com.musalasoft.gateways.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
public class PeripheralDeviceEntity extends BaseEntity{

    @Column(name="UID", length = 255, insertable = true, updatable = false)
    private String uid;

    @Column(name="VENDOR")
    private String vendor;

    @Column(name="CREATION_DATE")
    private Timestamp creationDate;

    @Column(name="ONLINE")
    private boolean online;

    public static final BigInteger B = BigInteger.ONE.shiftLeft(64);
    public static final BigInteger L = BigInteger.valueOf(Long.MAX_VALUE);

    @PrePersist
    public void convertToBigInteger() {
        UUID id = UUID.randomUUID();
        BigInteger lo = BigInteger.valueOf(id.getLeastSignificantBits());
        BigInteger hi = BigInteger.valueOf(id.getMostSignificantBits());

        // If any of lo/hi parts is negative interpret as unsigned

        if (hi.signum() < 0)
            hi = hi.add(B);

        if (lo.signum() < 0)
            lo = lo.add(B);

        BigInteger uid = lo.add(hi.multiply(B));
        this.uid = uid.toString();
    }


}
