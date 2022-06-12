package co.micol.bootstraptest.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.micol.bootstraptest.comm.Command;
import co.micol.bootstraptest.notice.service.NoticeService;
import co.micol.bootstraptest.notice.serviceImpl.NoticeServiceImpl;
import co.micol.bootstraptest.notice.vo.NoticeVO;

public class AjaxSearchList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 검색
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		ObjectMapper mapper = new ObjectMapper(); // json에서 제공하는 String으로 만들기위한 함수
		String key = request.getParameter("key");
		String val = request.getParameter("val");
		System.out.println(key + val);
		list = dao.noticeSearchList(key, val);
		String jsonData ="";
		try {
			jsonData = mapper.writeValueAsString(list);//리스트를 json String으로
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} 
		System.out.println(jsonData);
		return "ajax:" + jsonData;
	}

}
