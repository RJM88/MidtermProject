package com.skilldistillery.goatevents.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Venue {
	// FIELDS ============================================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String description;
	private int capacity;
	private String logo;
	@Column(name = "created_at")
	@CreationTimestamp
	private LocalDateTime createdAt;
	@Column(name = "last_update")
	@UpdateTimestamp
	private LocalDateTime lastUpdate;
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	@ManyToMany
	@JoinTable(name = "user_venue", joinColumns = @JoinColumn(name = "venue_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;
	
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private User user;
	
	@OneToMany(mappedBy = "venue")
	private List<Event> events;
	
	@OneToMany(mappedBy="venue")
	private List<VenueAmenity> venueAmenities;

	@ManyToMany
	@JoinTable(name = "venue_amenity", joinColumns = @JoinColumn(name = "venue_id"), inverseJoinColumns = @JoinColumn(name = "amenity_id"))
	private List<Amenity> amenities;
	public List<Amenity> getAmenities() {
		return amenities;
	}

	public void setAmenities(List<Amenity> amenities) {
		this.amenities = amenities;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// CONSTRUCTORS ======================================
	public Venue() {
		super();
	}

	// GETTERS AND SETTERS =============================
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int compacity) {
		this.capacity = compacity;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<VenueAmenity> getVenueAmenities() {
		return venueAmenities;
	}

	public void setVenueAmenities(List<VenueAmenity> venueAmenities) {
		this.venueAmenities = venueAmenities;
	}

	public void addVenueAmenity(VenueAmenity va) {
		if (venueAmenities == null) {
			venueAmenities = new ArrayList<VenueAmenity>();
		}
		if (!venueAmenities.contains(va)) {
			venueAmenities.add(va);
		}
	}

	public void removeVenueAmenity(VenueAmenity ve) {
		if (venueAmenities != null && venueAmenities.contains(ve)) {
			venueAmenities.remove(ve);
		}
	}

	public void addUser(User user) {
		if (users == null) {
			users = new ArrayList<User>();
		}
		if (!users.contains(user)) {
			users.add(user);
			user.addVenue(this);
		}
	}

	public void removeUser(User user) {
		if (users != null && users.contains(user)) {
			users.remove(user);
			user.removeVenue(this);
		}
	}
	public void addAmenity(Amenity a) {
		if (amenities == null) {
			amenities = new ArrayList<Amenity>();
		}
		if (!amenities.contains(a)) {
			amenities.add(a);
			a.addVenue(this);
		}
	}
	
	public void removeAmenity(Amenity a) {
		if (amenities != null && amenities.contains(a)) {
			amenities.remove(a);
			a.removeVenue(this);
		}
	}

	public void addEvent(Event e) {
		if (events == null) {
			events = new ArrayList<Event>();
		}
		if (!events.contains(e)) {
			events.add(e);
		}
	}

	public void removeEvent(Event e) {
		if (events != null && events.contains(e)) {
			events.remove(e);
		}
	}

	// Hashcode AND Equals =============================
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venue other = (Venue) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Venue [name=").append(name).append(", description=").append(description).append(", capacity=")
				.append(capacity).append(", address=").append(address).append("]");
		return builder.toString();
	}

}
