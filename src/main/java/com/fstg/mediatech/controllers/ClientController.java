package com.fstg.mediatech.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.mediatech.dto.ClientRequestDto;
import com.fstg.mediatech.dto.ClientResponseDto;
import com.fstg.mediatech.service.ClientService;

@RestController
@RequestMapping("clients")
public class ClientController {
    private ClientService clientService;
    public ClientController(  ClientService clientService){
        this.clientService = clientService;
    }
    @GetMapping("")
    public List <ClientResponseDto> getClient(){
        return clientService.findAll();
    }
    @PostMapping("")
    public ClientResponseDto save(@RequestBody()ClientRequestDto clientRequestDto){
        return clientService.save(clientRequestDto);
    }


   

}
