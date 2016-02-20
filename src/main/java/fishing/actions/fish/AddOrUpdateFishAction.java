package fishing.actions.fish;


import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.annotations.DoubleRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.IntRangeFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import com.opensymphony.xwork2.validator.validators.ValidatorSupport;

import fishing.dao.Fish;
import fishing.services.FishListService;
import fishing.actions.PublicAction;

@Namespace("/")
@ResultPath(value = "/WEB-INF/fishs")
@Action(value = "FishEdit", results = { @Result(name = "success", location = "fishs.jsp"),
			@Result(name = "input", location = "fishs.jsp"),
			@Result(name = "invalid", location = "addOrUpdateFish.jsp"),
			@Result(name = "error", location = "../index.jsp") })
@Validations
public class AddOrUpdateFishAction extends ActionSupport implements ModelDriven<Fish> {
	private FishListService fishListService;
	private Fish fish;
	private boolean edit;
	private boolean delete;
	public AddOrUpdateFishAction() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub

		if (fishListService != null) {
			if(fish == null)
				return "input";
			int t = fish.getId();
			if (t > 0) {
				fish = fishListService.getFish(fish.getId());
				return fish == null ? "error" : "success";
			}
			return "success";
		}
		return "error";
	}
	@Action(value = "FishUpdate", results = { @Result(name = "success",type="redirect", location = "FishsEditor"),
			@Result(name = "invalid", location = "addOrUpdateFish.jsp"),
			@Result(name = "input", location = "addOrUpdateFish.jsp"),
			@Result(name = "error", location = "index.jsp") })
	@RequiredStringValidator(type = ValidatorType.FIELD, fieldName = "name", message = "Name required !!!!!!!!!!!!!!!!")
	@DoubleRangeFieldValidator(type = ValidatorType.FIELD, fieldName = "price", message="Value should be 0.....999999", minExclusive="0", maxExclusive="999999")
	@StringLengthFieldValidator(fieldName="name", maxLength="100", message="Name's length shouldn't be greater than 100")
	public String update() throws Exception {
		Logger logger = LogManager.getRootLogger();
		if(fish == null)
		{
			logger.error("FISH for ubdate is null!");
			return "error";			
		}
		logger.error("fish isn't null!!! Success!!!");
		if (fishListService != null) {
			if(fish.getName() != null && !fish.getName().isEmpty())
			{
				fishListService.addOrUpdateFish(fish);
				return "success";
			}
			return "invalid";
		}
		return "error";
	}
	@Action(value = "FishDelete", results = { @Result(name = "success",type="redirect", location = "FishsEditor"),
			@Result(name = "error", location = "index.jsp") })
	public String delete(){
		if (fishListService != null) {
			fishListService.deleteFish(fish);
			return "success";
		}
		return "error";
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
	public Fish getModel() {
		return fish;
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

	public Fish getFish() {
		return fish;
	}

	public void setFish(Fish fish) {
		this.fish = fish;
	}

}
