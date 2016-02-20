package fishing.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Catch {
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Trip trip;
	@ManyToOne
	private Fish fish;
	private double weight;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	public Fish getFish() {
		return fish;
	}
	public void setFish(Fish fish) {
		this.fish = fish;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
