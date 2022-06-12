package co.micol.study.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.study.notice.vo.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSelectList();
	
//	List<NoticeVO> noticeSelectList(String key, String val); Mapper는 하나이상의 전달인자를 인식하지못함
	List<NoticeVO> searchList(@Param("key") String key, @Param("val") String val);
	
	NoticeVO noticeSelect(NoticeVO vo);
	
	int noticeInsert(NoticeVO vo);
	
	int noticeUpdate(NoticeVO vo);
	
	int noticeDelete(NoticeVO vo);
	
	int noticeHitUpdate(int id); //조회수 증가 메소드
	
}
