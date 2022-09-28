package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.TicketDetails;

public interface TicketDetailsDao extends JpaRepository<TicketDetails, Integer> {

}
