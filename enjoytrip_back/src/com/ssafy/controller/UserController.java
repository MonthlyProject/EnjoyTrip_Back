package com.ssafy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.member.model.service.UserService;
import com.ssafy.member.model.service.UserServiceImpl;
import com.ssafy.user.model.UserDto;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private UserService userService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		userService = UserServiceImpl.getInstance();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
    	String path="";

    	
    	
    	if("signup".equals(action)) { // 회원 가입
    		UserDto user = new UserDto();
    		user.setUserName(request.getParameter("joinName"));
    		user.setUserId(request.getParameter("joinId"));
    		user.setUserPwd(request.getParameter("joinPassword"));
    		user.setEmailId(request.getParameter("joinEmailId"));
    		user.setEmailDomain(request.getParameter("joinEmailDomain"));
    		
    		try {
    			int res = userService.signUp(user);
    			if(res == 1) { // 회원가입 성공!!
    				HttpSession session = request.getSession();
    				session.setAttribute("msg", "회원가입 성공!!");
    				redirect(request, response, path);
    			}
    		} catch(Exception e) {
    			e.printStackTrace();
    			
    			System.out.println("회원가입 오류!! ");
    			request.setAttribute("msg", "회원가입 중 오류가 발생했습니다.");
    			forward(request, response, "/user?action=error");
    		}
    	} else if("signin".equals(action)) { // 로그인
    		UserDto user = new UserDto();
    		user.setUserId(request.getParameter("loginId"));
    		user.setUserPwd(request.getParameter("loginPassword"));
    		
    		try {
    			UserDto res = userService.signIn(user);
    			if(res == null) { // 로그인 실패
    				
    			} else {
    				HttpSession session = request.getSession();
    				session.setAttribute("userInfo", res);
    				path = "";
    				redirect(request, response, path);
    			}
    		} catch(Exception e) {
    			e.printStackTrace();
    			System.out.println("로그인 오류!! ");
    			request.setAttribute("msg", "로그인 중 오류가 발생했습니다.");
    			forward(request, response, "/user?action=error");
    		}
    		
    	} else if("signout".equals(action)) {
    		HttpSession session = request.getSession();
    		session.invalidate();
//    		session.setAttribute("msg", "로그아웃 성공!");
    		redirect(request, response, path);
    	}
    	
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}

	

}
