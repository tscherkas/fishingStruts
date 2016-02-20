package fishing.actions;

import java.sql.Date;
import java.text.DateFormat;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import fishing.services.CatersListService;
import fishing.services.TripsService;
import fishing.actions.viewModels.*;
import fishing.dao.Cater;
import fishing.dao.Trip;

@Namespace("/")
@ResultPath(value = "/WEB-INF")
public class TeamsAndTripsAction extends ActionSupport implements ModelDriven<Object> {

	private TripsService tripsService;
	private TripsViewModel tripsViewModel;
	private CatersListService catersListService;

	@Action(value = "TeamsAndTrips", results = { @Result(name = "success", location = "teams.jsp"),
			@Result(name = "error", location = "error.jsp") })
	@Override
	public String execute() {
		List<Cater> catersList = catersListService.getOpenCatersNamesList();
		List<Trip> tripsList = tripsService.getTripsList();
		if (catersList != null && tripsList != null) {
			tripsViewModel.setCatersList(catersList);
			tripsViewModel.setTripsList(tripsList);
			return SUCCESS;
		}
		return ERROR;
	}

	@Action(value = "CreateTrip", results = { @Result(name = "success", location = "tripCreated.jsp"),
			@Result(name = "error", location = "error.jsp") })
	public String createTrip() {

		if (tripsViewModel.getTrip().getDepartureDate().before(tripsViewModel.getTrip().getArrivalDate())) {
			tripsService.addOrUpdateTrip(tripsViewModel.getTrip());
			tripsViewModel.getTrip().setCater(catersListService.getCater(tripsViewModel.getTrip().getCater().getId()));
			return SUCCESS;
		}
		return ERROR;

	}

	@Action(value = "DeleteTrip", results = { @Result(name = "success", type = "redirect", location = "TeamsAndTrips"),
			@Result(name = "error", location = "error.jsp") })
	public String deleteTrip() {

		try {
			tripsService.deleteTrip(tripsViewModel.getTrip());
			return SUCCESS;
		} catch (Exception ex) {
			return ERROR;
		}

	}

	@Override
	public TripsViewModel getModel() {
		return tripsViewModel;
	}

	public CatersListService getCatersListService() {
		return catersListService;
	}

	public void setCatersListService(CatersListService catersListService) {
		this.catersListService = catersListService;
	}

	public TripsService getTripsService() {
		return tripsService;
	}

	public void setTripsService(TripsService tripsService) {
		this.tripsService = tripsService;
	}

	public TripsViewModel getTripsViewModel() {
		return tripsViewModel;
	}

	public void setTripsViewModel(TripsViewModel tripsViewModel) {
		this.tripsViewModel = tripsViewModel;
	}

}
