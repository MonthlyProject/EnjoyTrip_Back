package com.ssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.map.model.GugunDto;
import com.ssafy.map.model.MarkerDto;
import com.ssafy.map.model.SidoDto;
import com.ssafy.map.model.service.MapService;
import com.ssafy.map.model.service.MapServiceImpl;

/**
 * Servlet implementation class MapController
 */
@WebServlet("/map")
public class MapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MapService mapService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		mapService = MapServiceImpl.getMapService();
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
    	String path="";
    	if("area".equals(action)) {
    		path = area(request, response);
    		forward(request, response, path);
    	} else if("areaarea".equals(action)) {
    		System.out.println("시도");
    		String json = areaarea(request, response);
    		response.setCharacterEncoding("utf-8");
    		response.setContentType("text/plain");
			PrintWriter out = response.getWriter();
			out.print(json);
    	} else if("search".equals(action)) {
    		String json = search(request, response);
    		response.setCharacterEncoding("utf-8");
    		response.setContentType("text/plain");
			PrintWriter out = response.getWriter();
			out.print(json);
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
	
	private String area(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<SidoDto> list = mapService.getSido();
			request.setAttribute("sido", list);
			
			return "/map/map.jsp";
		} catch (Exception e) {
			request.setAttribute("msg", "시도 출력 중 문제 발생!!!");
			e.printStackTrace();
		}
		return "/index.jsp";
	}
	
	private String areaarea(HttpServletRequest request, HttpServletResponse response) {
		String json="";
		try {
			int area = Integer.parseInt(request.getParameter("area"));
			List<GugunDto> list = mapService.getGugun(area);
			json="{\"gugun\":[" + list.get(0).toString();
			for(int i=1; i<list.size(); i++) {
				json+=", "+list.get(i).toString();
			}
			json+="]}";
			return json;
		} catch (Exception e) {
			request.setAttribute("msg", "시도 출력 중 문제 발생!!!");
			e.printStackTrace();
		}
		return json;
	}
	
	private String search(HttpServletRequest request, HttpServletResponse response) {
		String json="";
		try {
			int area = Integer.parseInt(request.getParameter("area"));
			int areaarea = Integer.parseInt(request.getParameter("areaarea"));
			int type = Integer.parseInt(request.getParameter("type"));
			System.out.println(area + " " +areaarea + " " + type);
			
			List<MarkerDto> list = mapService.getMarker(area, areaarea, type);
			
			json="{\"marker\":[" + list.get(0).toString();
			for(int i=1; i<list.size(); i++) {
				json+=", "+list.get(i).toString();
			}
			json+="]}";
			return json;
		} catch (Exception e) {
			request.setAttribute("msg", "시도 출력 중 문제 발생!!!");
			e.printStackTrace();
		}
		return json;
	}
}
