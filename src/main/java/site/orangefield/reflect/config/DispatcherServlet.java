package site.orangefield.reflect.config;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.orangefield.reflect.config.web.RequestMapping;
import site.orangefield.reflect.util.UtilsLog;
import site.orangefield.reflect.web.MemberController;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

	public DispatcherServlet() {

	}

	private static final long serialVersionUID = 1L; // 지금은 몰라도 됨. 그냥 걸어두셈
	private static final String TAG = "DispatcherServlet : ";

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UtilsLog.getInstance().info(TAG, "doDelete()");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberController memberController = new MemberController();

		UtilsLog.getInstance().info(TAG, "doGet()");
		UtilsLog.getInstance().info(TAG, req.getRequestURI());

		String identifier = req.getRequestURI();

		// 리플렉션 발동 /login
		Method[] methods = memberController.getClass().getDeclaredMethods();
		for (Method method : methods) {

			Annotation annotation = method.getDeclaredAnnotation(RequestMapping.class);
			RequestMapping requestMapping = (RequestMapping) annotation;

			if (identifier.equals(requestMapping.value())) {
				try {
					Parameter[] params = method.getParameters();
					for (Parameter param : params) {
						// 1. HttpServletRequest 찾아서 req 넣기

						// 2. HttpServletRequest 찾아서 resp 넣기

						// 3. Member 찾았는데 없다! -> new해서 넣어주기

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UtilsLog.getInstance().info(TAG, "doPost()");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UtilsLog.getInstance().info(TAG, "doPut()");
	}

}
