package com.musalasoft.gateways.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
public class GatewayModel {

    private Long id;
    private String name;
    private String serialNumber;

    @NotNull
    @Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
    private String ip;

    @Size(min=1, max=3)
    private Set<PeripheralDeviceModel> devices;

}
