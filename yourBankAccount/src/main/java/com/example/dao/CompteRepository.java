package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Compte;
@Repository
public interface CompteRepository extends JpaRepository<Compte, String> {

}
