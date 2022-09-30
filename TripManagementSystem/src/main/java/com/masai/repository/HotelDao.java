package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.Hotel;

public interface HotelDao extends JpaRepository<Hotel, Integer>{

}
