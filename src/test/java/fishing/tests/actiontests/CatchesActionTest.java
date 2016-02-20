package fishing.tests.actiontests;

import org.apache.struts2.StrutsSpringTestCase;
import org.springframework.test.context.ContextConfiguration;

import com.opensymphony.xwork2.ActionProxy;

import fishing.actions.CatchesAction;

@ContextConfiguration(locations = { "/WEB-INF/applicationContext.xml" })

public class CatchesActionTest extends StrutsSpringTestCase {
	

	public void test() throws Exception {

		//request.setParameter("accountBean.userName", "Bruc");
		//request.setParameter("accountBean.password", "test");

		ActionProxy proxy = getActionProxy("/Catches");

		CatchesAction action = (CatchesAction) proxy.getAction();

		String result = proxy.execute();

		assertTrue("CatchesAction didn't executed successfully.", result.equals("success"));

	}
}
