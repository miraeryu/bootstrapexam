package co.micol.bootstraptest.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.bootstraptest.notice.vo.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList(); //전체 조회
	List<NoticeVO> noticeSearchList(@Param("key") String key, @Param("val") String val);
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	int noticeHitUpdate(int hit);
}
