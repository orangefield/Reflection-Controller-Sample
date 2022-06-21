package site.orangefield.reflect.web;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import site.orangefield.reflect.config.MessageConverter;
import site.orangefield.reflect.config.ViewResolver;
import site.orangefield.reflect.config.web.RequestMapping;
import site.orangefield.reflect.domain.Member;
import site.orangefield.reflect.util.UtilsLog;

// API
public class MemberController{

	private static final String TAG = "MemberController : ";
	
	/* GET /join */
	@RequestMapping("/join")
	public void join(Member member, HttpServletRequest request, HttpServletResponse response) throws Exception {
		UtilsLog.getInstance().info(TAG, "join()");
		UtilsLog.getInstance().info(TAG, "Service가 호출되어 회원가입이 완료되었습니다");
		UtilsLog.getInstance().info(TAG, member.getUsername() +", "+member.getPassword());
//		HttpSession session = request.getSession();
//		response.sendRedirect("main.jsp"); // ViewResolver가 찾아줌
		request.setAttribute("username", "ares");
		ViewResolver.resolve("main.jsp", request, response);
	}
	
	/* GET /login */
	@RequestMapping(value = "/login")
	public void login(HttpServletRequest request, HttpServletResponse response) {
		UtilsLog.getInstance().info(TAG, "login()");
		UtilsLog.getInstance().info(TAG, "Service가 호출되어 로그인이 완료되었습니다");
		HttpSession session = request.getSession();
		session.setAttribute("principal", new Member(1, "ares", "1234"));
		ViewResolver.resolve("main.jsp", request, response);
	}
	
	/* GET /findById */
	@RequestMapping(value = "/findById")
	public void findById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		UtilsLog.getInstance().info(TAG, "findById()");
		UtilsLog.getInstance().info(TAG, "Service가 호출되어 Member를 찾았습니다");
		
		Member memberEntity = new Member(1, "ares", "1234");
		MessageConverter.resolve(memberEntity, response);
	}
}
