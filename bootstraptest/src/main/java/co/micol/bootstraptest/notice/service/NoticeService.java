package co.micol.bootstraptest.notice.service;

import java.util.List;

import co.micol.bootstraptest.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeSelectList(); //전체 조회
	List<NoticeVO> noticeSearchList(String key, String val);
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	int noticeHitUpdate(int hit);
}
