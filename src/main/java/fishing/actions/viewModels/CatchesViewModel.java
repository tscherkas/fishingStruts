package fishing.actions.viewModels;

import fishing.dao.Trip;

import java.util.List;

import fishing.dao.Catch;
import fishing.dao.Fish;

public class CatchesViewModel {
	private List<Trip> tripsList;
	private List<Catch> catchesList;
	private List<Fish> fishsList;
	private Catch catch_;
	
	public List<Trip> getTripsList() {
		return tripsList;
	}

	public void setTripsList(List<Trip> tripsList) {
		this.tripsList = tripsList;
	}

	public List<Catch> getCatchesList() {
		return catchesList;
	}

	public void setCatchesList(List<Catch> catchesList) {
		this.catchesList = catchesList;
	}

	public Catch getCatch_() {
		return catch_;
	}

	public void setCatch_(Catch catch_) {
		this.catch_ = catch_;
	}

	public List<Fish> getFishsList() {
		return fishsList;
	}

	public void setFishsList(List<Fish> fishsList) {
		this.fishsList = fishsList;
	}

}
