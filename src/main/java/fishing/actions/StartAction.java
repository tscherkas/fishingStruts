package fishing.actions;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
@Namespace("/")
public class StartAction implements PublicAction {
	@Action(value="index", results={@Result( name="success", location="/WEB-INF/index.jsp")})
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}

}
