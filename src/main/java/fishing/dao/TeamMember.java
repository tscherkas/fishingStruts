package fishing.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TeamMember {

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Fisher fisher;
	private String role;
	@ManyToOne
	private Trip trip;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Fisher getFisher() {
		return fisher;
	}
	public void setFisher(Fisher fisher) {
		this.fisher = fisher;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
}
