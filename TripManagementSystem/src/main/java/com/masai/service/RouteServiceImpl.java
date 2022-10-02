package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.BusException;
import com.masai.exceptions.RouteException;
import com.masai.models.Bus;
import com.masai.models.Route;
import com.masai.models.TicketDetails;
import com.masai.repository.BusDao;
import com.masai.repository.RouteDao;
import com.masai.repository.TicketDetailsDao;

@Service
public class RouteServiceImpl implements IRouteService{

	@Autowired RouteDao routeDao;
	@Autowired BusDao busDao;
	@Autowired TicketDetailsDao ticketDetailsDao;

	@Override
	public Route addRoute(Route route) {
		Route route2 = routeDao.save(route);
//		TicketDetails ticketDetails = new TicketDetails();
//		ticketDetails.setRoute(route2);
//		ticketDetails.setStatus("not booked");
//		ticketDetailsDao.save(ticketDetails);
		return route2;
	}

	@Override
	public Route updateRoute(Integer routeId,Integer busId) throws RouteException,BusException{
		Optional<Route> opt = routeDao.findById(routeId);
		Optional<Bus> opt2 = busDao.findById(busId);
		if(opt.isPresent()) {
			if(opt2.isPresent()) {
				Route route = opt.get();
				Bus bus = opt2.get();
				route.setBus(bus);
				
				TicketDetails ticketDetails = new TicketDetails();
				ticketDetails.setRoute(route);
				ticketDetails.setStatus("not booked");
				ticketDetailsDao.save(ticketDetails);
				return routeDao.save(route);
			}
			else throw new BusException("Bus not found");
		}
		else throw new RouteException("route not found with route id : " + routeId);
	}
	
	
	@Override
	public Route removeRoute(int routeId) throws RouteException {
		Optional<Route> rOptional=routeDao.findById(routeId);
		if (!rOptional.isPresent()) {
			throw new RouteException("This Route is not present in database to delete.");
		}
		routeDao.delete(rOptional.get());
		return rOptional.get();
	}

	@Override
	public Route searchRoute(int routeId) throws RouteException {
		Optional<Route> rOptional=routeDao.findById(routeId);
		if (!rOptional.isPresent()) {
			throw new RouteException("The Route you are searching is not present in database.");
		}
		return rOptional.get();
	}

	@Override
	public List<Route> viewRouteList() throws RouteException {
		List<Route> lRoute=routeDao.findAll();
		if (lRoute.isEmpty()) {
			throw new RouteException("No route is there in database to show.");
		}
		return lRoute;
	}
	
}
