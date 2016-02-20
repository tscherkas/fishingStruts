package fishing.actions;



import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import fishing.services.CatchesService;
import fishing.services.FishListService;
import fishing.services.TripsService;
import fishing.actions.viewModels.*;

@Namespace("/")
@ResultPath(value = "/WEB-INF")
public class CatchesAction extends ActionSupport implements ModelDriven<Object>, PublicAction {

	private TripsService tripsService;
	private FishListService fishListService;
	private CatchesService  catchesService;
	private CatchesViewModel catchesViewModel;

	@Action(value = "Catches", results = { @Result(name = "success", location = "catches.jsp"),
			@Result(name = "error", location = "error.jsp") })
	@Override
	public String execute() {
		
		if (tripsService != null && catchesService != null&&fishListService != null) {
			catchesViewModel.setCatchesList(catchesService.getCatchesList());
			catchesViewModel.setTripsList(tripsService.getTripsList());
			catchesViewModel.setFishsList(fishListService.getFishList());
			return SUCCESS;
		}
		return ERROR;
	}

	@Action(value = "CreateCatch", results = { @Result(name = "success", type = "redirect", location = "Catches"),
			@Result(name = "error", location = "error.jsp") })
	public String createCatch() {

		if (catchesViewModel.getCatch_().getTrip()!=null&&
				catchesViewModel.getCatch_().getFish()!=null) {
			catchesService.createCatch(catchesViewModel.getCatch_());
			catchesViewModel.getCatch_().setFish(fishListService.getFish(catchesViewModel.getCatch_().getFish().getId()));
			catchesViewModel.getCatch_().setTrip(tripsService.getTrip(catchesViewModel.getCatch_().getTrip().getId()));
			return SUCCESS;
		}
		return ERROR;

	}

	@Action(value = "DeleteCatch", results = { @Result(name = "success", type = "redirect", location = "Catches"),
			@Result(name = "error", location = "error.jsp") })
	public String deleteTrip() {

		try {
			catchesService.deleteCatch(catchesViewModel.getCatch_());
			return SUCCESS;
		} catch (Exception ex) {
			return ERROR;
		}

	}

	@Override
	public CatchesViewModel getModel() {
		return catchesViewModel;
	}

	public TripsService getTripsService() {
		return tripsService;
	}

	public void setTripsService(TripsService tripsService) {
		this.tripsService = tripsService;
	}



	public CatchesService getCatchesService() {
		return catchesService;
	}

	public void setCatchesService(CatchesService catchesServise) {
		this.catchesService = catchesServise;
	}

	public FishListService getFishListService() {
		return fishListService;
	}

	public void setFishListService(FishListService fishListService) {
		this.fishListService = fishListService;
	}

	public CatchesViewModel getCatchesViewModel() {
		return catchesViewModel;
	}

	public void setCatchesViewModel(CatchesViewModel catchesViewModel) {
		this.catchesViewModel = catchesViewModel;
	}

}
