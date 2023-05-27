package com.ssafy.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;
import com.ssafy.user.model.UserDto;
import com.ssafy.util.PageNavigation;
import com.ssafy.util.ParameterCheck;


@WebServlet("/article")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int pgno;
	private String key;
	private String word;
	private String queryString;
	private BoardService boardService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		boardService = BoardServiceImpl.getBoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		pgno = ParameterCheck.notNumberToOne(request.getParameter("pgno"));
		key = ParameterCheck.nullToBlank(request.getParameter("key"));
		word = ParameterCheck.nullToBlank(request.getParameter("word"));
		queryString = "?pgno=" + pgno + "&key=" + key + "&word=" + URLEncoder.encode(word, "utf-8");

		String path = "";
		if ("list".equals(action)) {
			path = list(request, response);
			forward(request, response, path);
		} else if ("view".equals(action)) {
			path = view(request, response);
			forward(request, response, path);
		} else if ("mvwrite".equals(action)) {
			path = "/board/write.jsp";
			forward(request, response, path);
		} else if ("write".equals(action)) {
			path = write(request, response);
			redirect(request, response, path);
		} else if ("mvmodify".equals(action)) {
			path = mvModify(request, response);
			forward(request, response, path);
		} else if ("modify".equals(action)) {
			path = modify(request, response);
			redirect(request, response, path);
			//			forward(request, response, path);
		} else if ("delete".equals(action)) {
			path = delete(request, response);
			redirect(request, response, path);
		} else {
			redirect(request, response, path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

	private String list(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userInfo");

		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("pgno", pgno + "");
			map.put("key", key);
			map.put("word", word);
			List<BoardDto> list = boardService.listArticle(map);
			request.setAttribute("articles", list);

			PageNavigation pageNavigation = boardService.makePageNavigation(map);
			request.setAttribute("navigation", pageNavigation);

			return "/board/list.jsp" + queryString;
		} catch (Exception e) {
			request.setAttribute("msg", "시도 출력 중 문제 발생!!!");
			e.printStackTrace();
		}

		return "/index.jsp";

	}

	private String view(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserDto UserDto = (UserDto) session.getAttribute("userInfo");

		int articleNo = Integer.parseInt(request.getParameter("articleno"));
		try {
			BoardDto boardDto = boardService.getArticle(articleNo);
			boardService.updateHit(articleNo);
			request.setAttribute("article", boardDto);

			return "/board/view.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "글내용 출력 중 문제 발생!!!");
		}

		return "/index.jsp";
	}

	private String write(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userInfo");

		BoardDto boardDto = new BoardDto();
		boardDto.setUserId(userDto.getUserId());
		boardDto.setSubject(request.getParameter("subject"));
		boardDto.setContent(request.getParameter("content"));
		try {
			boardService.writeArticle(boardDto);
			return "/article?action=list&pgno=1&key=&word=";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "글작성 중 문제 발생!!!");
		}

		return "/index.jsp";
	}


	private String mvModify(HttpServletRequest request, HttpServletResponse response) {
		// TODO : 수정하고자하는 글의 글번호를 얻는다.
		// TODO : 글번호에 해당하는 글정보를 얻고 글정보를 가지고 modify.jsp로 이동.
		try {
			HttpSession session = request.getSession();
			UserDto userDto = (UserDto) session.getAttribute("userInfo");

			int articleNo = Integer.parseInt(request.getParameter("articleno"));
			BoardDto boardDto = boardService.getArticle(articleNo);
			request.setAttribute("article", boardDto);
			return "/board/modify.jsp";

		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "글 수정 중 문제 발생!!!");
		}
		return "/index.jsp";
	}

	private String modify(HttpServletRequest request, HttpServletResponse response) {
		// TODO : 수정 할 글정보를 얻고 BoardDto에 set.
		// TODO : boardDto를 파라미터로 service의 modifyArticle() 호출.
		// TODO : 글수정 완료 후 view.jsp로 이동.(이후의 프로세스를 생각해 보세요.)
		BoardDto boardDto = new BoardDto();
		boardDto.setArticleNo(Integer.parseInt(request.getParameter("articleno")));
		System.out.println(request.getParameter("articleno"));
		boardDto.setSubject(request.getParameter("subject"));
		boardDto.setContent(request.getParameter("content"));

		try {
			boardService.modifyArticle(boardDto);
			return "/article?action=list&pgno=1&key=&word=";
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "글 수정 중 문제 발생!!!");
		}
		return "/index.jsp";
	}

	private String delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO : 삭제할 글 번호를 얻는다.
		// TODO : 글번호를 파라미터로 service의 deleteArticle()을 호출.
		// TODO : 글삭제 완료 후 list.jsp로 이동.(이후의 프로세스를 생각해 보세요.)
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userInfo");

		int articleNo = Integer.parseInt(request.getParameter("articleno"));
		try {
			boardService.deleteArticle(articleNo);
			return "/article?action=list&pgno=1&key=&word=";
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "글 삭제 중 문제 발생!!!");
		}

		return "/index.jsp";
	}
}
