package com.fstg.mediatech.service;

import java.util.List;

import com.fstg.mediatech.dto.ClientRequestDto;
import com.fstg.mediatech.dto.ClientResponseDto;

public interface ClientService {

    ClientResponseDto save(ClientRequestDto clientRequestDto);
    ClientResponseDto findById(int id);
    ClientResponseDto findByNom(String nom);
    void delete(int id);
    ClientResponseDto update(ClientRequestDto clientRequestDto , int id);

    List<ClientResponseDto> findAll();
}
