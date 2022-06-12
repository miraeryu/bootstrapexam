package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 모든 요청을 받아서 처리하는 곳
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>(); 
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    //요청과 처리를 연결하는 부분
    @Override
    public void init(ServletConfig config) throws ServletException { //대소문자 주의
    	map.put("/test.do", new TestCommand());
    	map.put("/MemberList.do", new MemberListCommand());
    }

    //요기서 들어온 요청을 분석하고 명령을 실행해서 결과를 되돋려보낸다
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8"); // 한글깨짐방지
    	String uri = request.getRequestURI(); // 요청 URI 구함
    	String contextPath = request.getContextPath(); // 루트 디렉토리 정보
    	String page = uri.substring(contextPath.length()); // 실제 명령 요청을 받음
    	
    	Command command = map.get(page); //실행할 명력 객체를 찾음
    	String viewPage = command.exec(request, response); //명령을 실행하고 결과를 돌려받음
    	//     =test1
    	
    	if(!viewPage.endsWith(".do") && !viewPage.equals(null)) { // View REsolve
    		viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp";
    	}
    	//결과 페이지를 돌려준다.
    	RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
    	dispatcher.forward(request,response);
    }
    

}
