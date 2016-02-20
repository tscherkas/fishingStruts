package fishing.actions.fish;



import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import fishing.actions.PublicAction;
import fishing.dao.Fish;
import fishing.services.FishListService;
@Namespace("/")
@ResultPath(value="/WEB-INF/fishs")
public class ShowFishsAction extends ActionSupport implements ModelDriven< List<Fish> >, PublicAction {
	private FishListService fishListService;
	private List<Fish> model;
	@Action(value="Fishs", results={
			@Result(name="success",location="fishsRates.jsp"),
			@Result(name="error",location="../index.jsp")
		})
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(fishListService != null)
		{
			model = fishListService.getFishList();
			return SUCCESS;
		}
		return ERROR;
	}
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}

	public FishListService getFishListService() {
		return fishListService;
	}

	public void setFishListService(FishListService fishListService) {
		this.fishListService = fishListService;
	}

	@Override
	public List<Fish> getModel() {
		return model;
	}

	

}
