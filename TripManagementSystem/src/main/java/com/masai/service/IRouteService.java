package com.masai.service;

import java.util.List;

import com.masai.exceptions.BusException;
import com.masai.exceptions.RouteException;
import com.masai.models.Route;

public interface IRouteService {
	Route addRoute(Route route);
	Route updateRoute(Integer routeId,Integer busId) throws RouteException,BusException;
	public Route removeRoute(int routeId) throws RouteException;
	public Route searchRoute(int routeId) throws RouteException;
	public List<Route> viewRouteList() throws RouteException;
}
