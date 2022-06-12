package co.micol.study.notice.service;

import java.util.List;

import co.micol.study.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeSelectList();
	
	List<NoticeVO> searchList(String key, String val);
	
	NoticeVO noticeSelect(NoticeVO vo);
	
	int noticeInsert(NoticeVO vo);
	
	int noticeUpdate(NoticeVO vo);
	
	int noticeDalete(NoticeVO vo);
	
	int noticeHitUpdate(int id); //조회수 증가 메소드

}
