package co.micol.study.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.study.comm.Command;
import co.micol.study.home.HomeCommand;
import co.micol.study.notice.command.NoticeSelect;
import co.micol.study.notice.command.NoticeSelectList;
import co.micol.study.student.command.Login;
import co.micol.study.student.command.LoginForm;
import co.micol.study.student.command.Logout;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException { // init : 초기화
		map.put("/home.do", new HomeCommand()); //홈 페이지
		map.put("/noticeSelectList.do", new NoticeSelectList());  //공지사항
		map.put("/noticeSelect.do", new NoticeSelect()); //세부내역보기
		map.put("/loginForm.do", new LoginForm()); //로그인 폼
		map.put("/login.do", new Login());
		map.put("/logout.do", new Logout());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath(); //uri - contextPath = 실제 요청 내용
		String page = uri.substring(contextPath.length()); //contextPath의 길이만큼 자름
		
		Command command = map.get(page); // map에서 요청사항 입력 = value를 돌려받음
		String viewPage = command.exec(request, response);
		
		if(!viewPage.endsWith(".do") && !viewPage.equals(null)) { // viewResolve
//			viewPage = "/WEB-INF/views/" + viewPage + ".jsp";
			viewPage = viewPage + ".tiles";
		}
		System.out.println(viewPage);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); //dispatcher >> 권한 이임, 내가 만들 request객체를 가져감
		dispatcher.forward(request, response);
	}

}
