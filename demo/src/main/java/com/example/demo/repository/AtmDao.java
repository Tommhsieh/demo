package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Atm;

public interface AtmDao extends JpaRepository<Atm,String>{
	
	
}
