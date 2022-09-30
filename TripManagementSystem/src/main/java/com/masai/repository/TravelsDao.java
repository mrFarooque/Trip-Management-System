package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.Travels;

public interface TravelsDao extends JpaRepository<Travels, Integer> {

}
