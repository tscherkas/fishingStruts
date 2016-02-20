package fishing.actions.tests;

import org.apache.struts2.StrutsTestCase;

import com.opensymphony.xwork2.ActionProxy;

import fishing.actions.CatchesAction;

public class CatchesActionTest extends StrutsTestCase {
	

	public void test() throws Exception {

		request.setParameter("accountBean.userName", "Bruc");
		request.setParameter("accountBean.password", "test");

		ActionProxy proxy = getActionProxy("Catches");

		CatchesAction action = (CatchesAction) proxy.getAction();

		String result = proxy.execute();

		assertTrue("CatchesAction didn't executed successfully.", result.equals("success"));

	}
}
