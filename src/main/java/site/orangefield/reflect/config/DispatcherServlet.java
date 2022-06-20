package site.orangefield.reflect.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.orangefield.reflect.util.UtilsLog;
import site.orangefield.reflect.web.MemberController;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet{
	
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
		MemberController controller = new MemberController();

		
		UtilsLog.getInstance().info(TAG, "doGet()");
		UtilsLog.getInstance().info(TAG, req.getRequestURI());
		
		String identifier = req.getRequestURI();
		
		if(identifier.equals("/join")) {
				try {
					controller.join(req, resp);
				} catch (Exception e) {
					e.printStackTrace();
				}
		} else if(identifier.equals("/login")) {		
			controller.login(req, resp);			
		} else if(identifier.equals("/findById")) {		
			controller.findById(req, resp);			
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
