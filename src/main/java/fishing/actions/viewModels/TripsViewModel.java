package fishing.actions.viewModels;

import java.util.Date;
import java.util.List;

import fishing.dao.Cater;
import fishing.dao.Trip;

public class TripsViewModel {
	private List<Cater> catersList;
	private List<Trip>	tripsList;
	private int caterId;
	private Date date1;
	private Date date2;
	private Trip trip;

	public void TripsViewModel() {
		trip = new Trip();
		trip.setCater(new Cater());
	}

	public int getCaterId() {
		return caterId;
	}

	public void setCaterId(int caterId) {
		this.caterId = caterId;
	}

	// public String getDate1() {
	// return date1;
	// }
	// public void setDate1(String date1) {
	// this.date1 = date1;
	// }
	// public String getDate2() {
	// return date2;
	// }
	// public void setDate2(String date2) {
	// this.date2 = date2;
	// }
	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public List<Cater> getCatersList() {
		return catersList;
	}

	public void setCatersList(List<Cater> catersList) {
		this.catersList = catersList;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public List<Trip> getTripsList() {
		return tripsList;
	}

	public void setTripsList(List<Trip> tripsList) {
		this.tripsList = tripsList;
	}
}