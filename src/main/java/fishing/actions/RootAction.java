package fishing.actions;

import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import fishing.actions.annotations.ForPublic;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
@Namespace("/")
@ForPublic()
public class RootAction extends ActionSupport implements PublicAction{
	@Action(value="*", results={@Result( name="success", location="/WEB-INF/index.jsp")})
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}

}
