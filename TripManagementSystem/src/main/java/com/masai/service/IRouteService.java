package com.masai.service;

import com.masai.exceptions.BusException;
import com.masai.exceptions.RouteException;
import com.masai.models.Route;

public interface IRouteService {
	Route addRoute(Route route);
	Route updateRoute(Integer routeId,Integer busId) throws RouteException,BusException;
}
