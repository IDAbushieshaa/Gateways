package com.musalasoft.gateways.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
public class PeripheralDeviceModel {

    private Long id;
    private String uid;
    private String vendor;
    private Timestamp creationDate;
    private boolean online;
}
