package com.fstg.mediatech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fstg.mediatech.models.ClientEntity;


@Repository
public interface ClientDao extends JpaRepository<ClientEntity, Integer> {
    ClientEntity  findByNom(String nom);
    

}
