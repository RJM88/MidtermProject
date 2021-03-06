package com.skilldistillery.goatevents.data;

import java.util.List;

import com.skilldistillery.goatevents.entities.Event;
import com.skilldistillery.goatevents.entities.Venue;

public interface EventDAO {
	
	public boolean  deleteEvent(int id);
	
	public Event updateEvent(Event event);

	Event findById(int id);
	
	Venue findVenueById(int id);

	List<Venue> findAll();

	Event addEvent(Event newEvent, int venueId);
}
