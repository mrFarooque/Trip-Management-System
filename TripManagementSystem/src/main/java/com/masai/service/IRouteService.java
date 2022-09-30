package com.masai.service;

import com.masai.exceptions.RouteException;
import com.masai.models.Route;

public interface IRouteService {
	Route addRoute(Route route);
	Route updateRoute(Route route) throws RouteException;
}
