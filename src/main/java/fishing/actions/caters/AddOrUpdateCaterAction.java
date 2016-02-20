package fishing.actions.caters;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import fishing.dao.Cater;
import fishing.dao.Fish;
import fishing.services.CatersListService;
import fishing.services.FishListService;

@Namespace("/")
@ResultPath(value = "/WEB-INF")
public class AddOrUpdateCaterAction extends ActionSupport implements ModelDriven<Cater> {
	private CatersListService catersListService;
	private Cater model;
	private boolean edit;
	private boolean delete;
	public AddOrUpdateCaterAction() {
		// TODO Auto-generated constructor stub
		model = new Cater();
	}

	
	@Action(value = "CaterUpdate", results = { @Result(name = "success", type = "redirect", location = "catersEditor"),
			@Result(name = "invalid", location = "addOrUpdateCater.jsp"),
			@Result(name = "error", location = "index.jsp") })
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		if (catersListService != null) {
			if(model.getName() != null && !model.getName().isEmpty())
			{
				catersListService.addOrUpdateCater(model);
				return "success";
			}
			return "invalid";
		}
		return "error";
	}
	@Action(value = "CaterDelete", results = { @Result(name = "success", type="redirect", location = "catersEditor"),
			@Result(name = "error", location = "index.jsp") })
	public String delete(){
		if (catersListService != null) {
			catersListService.deleteCater(model);
			return "success";
		}
		return "error";
	}
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}



	@Override
	public Cater getModel() {
		return model;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public CatersListService getCatersListService() {
		return catersListService;
	}

	public void setCatersListService(CatersListService catersListService) {
		this.catersListService = catersListService;
	}

}
