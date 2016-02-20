package fishing.actions;


import java.net.HttpCookie;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import fishing.dao.AppUser;
import fishing.services.AppUsersService;

@Namespace("/")
@ResultPath(value = "/WEB-INF")
public class RegisterAction extends ActionSupport implements ServletResponseAware,ServletRequestAware, ModelDriven<AppUser>, PublicAction {
	private AppUser model;
	private AppUsersService appUsersService;
	private HttpServletResponse response;
	private HttpServletRequest request;
	public RegisterAction() {
		model = new AppUser();
		appUsersService = new AppUsersService();
	}

	@Action(value = "register", results = { @Result(name = "success", location = "register.jsp")})
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	@Action(value = "regme", results = { @Result(name = "success", location = "login.jsp"),
			@Result(name = "error", location = "register.jsp") })
	public String register() throws Exception {
		// TODO Auto-generated method stub
		if(
				!model.getPassword().isEmpty()&&!model.getRepeatedPassword().isEmpty()&&
				model.getRepeatedPassword().equals(model.getPassword())&&
				model.getEmail()!=null&& !model.getEmail().isEmpty()&&
				model.getFirstName()!=null&& !model.getFirstName().isEmpty()
				)
		{
			if(appUsersService.addAppUser(model))
				return "success";
			else
				return "error";
		}
		return "error";
	}
	

	@Action(value = "login", results = { @Result(name = "success", location = "index.jsp"),
			@Result(name = "error", location = "login.jsp") })
	public String login() throws Exception {

		Map<String, String[]> i = request.getParameterMap();
		if(model.getEmail()!=null&&!model.getEmail().isEmpty()&&model.getPassword()!=null&&!model.getPassword().isEmpty())
		{
			if(appUsersService.isAppUser(model)){
				//response.addCookie(new Cookie("user", "OK"));
				ActionContext.getContext().getSession().put("user", model.getEmail());
				return "success";
			}
			else
				return "error";
		}
		return "error";
	}
	
	@Action(value = "logout", results = { @Result(name = "success",type = "redirect", location = "/fishing"),
			@Result(name = "error", location = "login.jsp") })
	public String logout() throws Exception {
		/*for(Cookie c : request.getCookies()) {
		      if (c.getName().equals("user")){
		        c.setMaxAge(0);
		        c.setValue("");
		        response.addCookie(c);
		      }
		    }*/
		ActionContext.getContext().getSession().remove("user");
		return "success";
	}
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}

	
	@Override
	public AppUser getModel() {
		return model;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	
}
