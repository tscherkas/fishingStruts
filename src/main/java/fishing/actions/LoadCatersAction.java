package fishing.actions;



import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import fishing.actions.annotations.ForPublic;
import fishing.dao.Cater;
import fishing.services.CatersListService;


@Namespace("/")
@ResultPath(value="/WEB-INF")
@ForPublic
@Deprecated
public class LoadCatersAction extends ActionSupport implements ModelDriven< List<Cater> >,PublicAction {
	private CatersListService catersListService;
	private List<Cater> model;
	
	

	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(catersListService != null)
		{
			model = catersListService.getCatersList();
			return SUCCESS;
		}
		return ERROR;
	}
	@Action(value="Caters", results={
			@Result(name="success",location="caters.jsp"),
			@Result(name="error",location="error.jsp")
		})
	public String catersList() throws Exception {
		// TODO Auto-generated method stub
		if(catersListService != null)
		{
			model = catersListService.getCatersList();
			return SUCCESS;
		}
		return ERROR;
	}
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}

	public CatersListService getFishListService() {
		return catersListService;
	}

	public void setCatersListService(CatersListService catersListService) {
		this.catersListService = catersListService;
	}

	@Override
	public List<Cater> getModel() {
		return model;
	}

	

}
