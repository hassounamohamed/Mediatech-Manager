package com.fstg.mediatech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fstg.mediatech.dto.ClientRequestDto;
import com.fstg.mediatech.dto.ClientResponseDto;
@Service()
public class ClientServiceImpl2 implements ClientService {
    @Override
    public ClientResponseDto save(ClientRequestDto clientRequestDto){
        return null;
    }
    @Override
    public ClientResponseDto findById(int id) {
        return null; 
    }

    @Override
    public ClientResponseDto findByNom(String nom) {
       
        return null; 
    }

    @Override
    public void delete(int id) {
        
    }

    @Override
    public ClientResponseDto update(ClientRequestDto clientRequestDto, int id) {
        
        return null; 
    }
    @Override
    public List <ClientResponseDto> findAll() {
        return null;
    }
}
