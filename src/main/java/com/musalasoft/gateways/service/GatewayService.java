package com.musalasoft.gateways.service;


import com.musalasoft.gateways.model.GatewayModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface GatewayService {

    public GatewayModel getGateway(@PathVariable long id);

    public void addGateway(@RequestBody GatewayModel gateway);

    public List<GatewayModel> getAll();
}
