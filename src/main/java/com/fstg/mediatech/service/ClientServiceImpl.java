package com.fstg.mediatech.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fstg.mediatech.dao.ClientDao;
import com.fstg.mediatech.dto.ClientRequestDto;
import com.fstg.mediatech.dto.ClientResponseDto;
import com.fstg.mediatech.models.ClientEntity;
@Service

public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao;
    private ModelMapper modelMapper;

    public ClientServiceImpl(ClientDao clientDao, ModelMapper modelMapper){
        this.clientDao = clientDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientResponseDto save(ClientRequestDto clientRequestDto){
        ClientEntity clientEntity=modelMapper.map(clientRequestDto,ClientEntity.class);
        ClientEntity saved=clientDao.save(clientEntity);
        return modelMapper.map(saved, ClientResponseDto.class);
    }
    @Override
    public ClientResponseDto findById(int id) {
        ClientEntity clientEntity=clientDao.findById(id).orElseThrow(()-> new RuntimeException("client not found"));
        return modelMapper.map(clientEntity, ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findByNom(String nom) {
        ClientEntity clientEntity=clientDao.findByNom(nom);
        return modelMapper.map(clientEntity, ClientResponseDto.class);
    }

    @Override
    public void delete(int id) {

        clientDao.deleteById(id);
               
    }

    @Override
    public ClientResponseDto update(ClientRequestDto clientRequestDto, int id){
        
        Optional<ClientEntity> ClientEntityOptional = clientDao.findById(id);
        if(ClientEntityOptional.isPresent()){
            ClientEntity clientEntity  = modelMapper.map(clientRequestDto , ClientEntity.class);
            clientEntity.setId(id);
            ClientEntity updated = clientDao.save(clientEntity);
            return modelMapper.map(updated, ClientResponseDto.class);
        }else{
            throw new RuntimeException("Client not found");

        }
    }


    @Override
    public List <ClientResponseDto> findAll() {
        return clientDao.findAll().stream().map(el ->modelMapper.map(el,ClientResponseDto.class))
        .collect(Collectors.toList());
    }

}
