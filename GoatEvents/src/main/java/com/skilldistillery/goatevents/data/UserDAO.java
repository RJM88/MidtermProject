package com.skilldistillery.goatevents.data;

import java.util.List;

import com.skilldistillery.goatevents.entities.Address;
import com.skilldistillery.goatevents.entities.Event;
import com.skilldistillery.goatevents.entities.User;
import com.skilldistillery.goatevents.entities.Venue;

public interface UserDAO {

	User addUser(User newUser);

	User addUserVenue(User newUser, Venue newVenue);

	User updateUser(int id, User user);

	boolean deactivateUser(int id);

	Venue addVenue(Venue newVenue);

	Address addAddress(Address newAddress);

	List<Event> findAllEvents();

	User login(String email, String password);

	boolean isVendor(User vendor);

	List<Venue> venueFavoritesList(User user);

	List<User> findAllUsers();

	List<Venue> findAllVenues();

	boolean isAdmin(User admin);

	User saveUser(User user);

}
