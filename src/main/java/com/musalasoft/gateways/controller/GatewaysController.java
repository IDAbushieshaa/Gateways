package com.musalasoft.gateways.controller;


import com.musalasoft.gateways.model.GatewayModel;
import com.musalasoft.gateways.service.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("gateways")
public class GatewaysController {

    @Autowired
    private GatewayService gatewayService;

    @GetMapping("/{id}")
    @ResponseBody
    public GatewayModel getGateway(@PathVariable long id) {
        return gatewayService.getGateway(id);
    }

    @PostMapping("create-gateway")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void saveGateway(@RequestBody @Valid GatewayModel gateway) {
        gatewayService.addGateway(gateway);
    }

    @GetMapping("/retrieve-all")
    @ResponseBody
    public List<GatewayModel> getAllGateways() {
        return gatewayService.getAll();
    }
}
