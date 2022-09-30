package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.RouteException;
import com.masai.models.Route;
import com.masai.repository.RouteDao;

@Service
public class RouteServiceImpl implements IRouteService{
	
	@Autowired RouteDao routeDao;

	@Override
	public Route addRoute(Route route) {
		return routeDao.save(route);
	}

	@Override
	public Route updateRoute(Route route) throws RouteException {
		Optional<Route> opt = routeDao.findById(route.getRouteId());
		if(opt.isPresent()) {
			return routeDao.save(route);
		}
		else throw new RouteException("route not found with route id : " + route.getRouteId());
	}
}
