package fishing.interceptors;
import fishing.actions.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		Object user = ActionContext.getContext().getSession().get("user");
		boolean logined = user!=null&&!user.toString().isEmpty();
		if (logined||invocation.getAction() instanceof PublicAction ) {
			return invocation.invoke();
		}

		return ActionSupport.LOGIN;
	}

}
