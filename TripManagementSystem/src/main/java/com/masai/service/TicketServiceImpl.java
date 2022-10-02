package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.models.TicketDetails;
import com.masai.repository.TicketDetailsDao;

@Service
public class TicketServiceImpl implements TicketService{
	@Autowired TicketDetailsDao ticketDetailsDao;
	
	@Override
	public TicketDetails addBusTicket(TicketDetails ticketDetails) {
		ticketDetails.setStatus("not booked");
		return ticketDetailsDao.save(ticketDetails);
	}

}
