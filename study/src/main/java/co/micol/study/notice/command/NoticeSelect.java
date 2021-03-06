package co.micol.study.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.study.comm.Command;
import co.micol.study.notice.service.NoticeService;
import co.micol.study.notice.serviceImpl.NoticeServiceImpl;
import co.micol.study.notice.vo.NoticeVO;

public class NoticeSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//세부목록보기
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setId(Integer.valueOf(request.getParameter("id")));  //읽을 아이디값 담음
		vo = dao.noticeSelect(vo);
		request.setAttribute("notice", vo);
		return "notice/noticeSelect";
	}

}
