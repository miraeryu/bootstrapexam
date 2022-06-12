package com.micol.notice.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.micol.notice.dao.DataSource;
import com.micol.notice.service.NoticeService;
import com.micol.notice.service.NoticeVO;

public class NoticeServiceImpl implements NoticeService {

	private DataSource dao = DataSource.getInstance();
	private Connection conn; // = dao.getConnection();

	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<NoticeVO> noticeSelectList() {
		// 전체 조회
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		NoticeVO vo;
		String sql = "SELECT * FROM NOTICE";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new NoticeVO();
				vo.setId(rs.getInt("id"));
				vo.setWriter(rs.getString("writer"));
				vo.setTitle(rs.getString("title"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setHit(rs.getInt("hit"));
				list.add(vo);
			}
		} catch (SQLException e) { // SQL 연결하기때문에 오류 설정 이렇게
			e.printStackTrace();

		}
		close();
		return list;
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		// 글 세부 조회 (한개의 공지사항 읽음)
		String sql = "select * from notice where id = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			rs = psmt.executeQuery();
			if (rs.next()) { // 1개만 넘어올경우 if
				vo = new NoticeVO();
				vo.setId(rs.getInt("id"));
				vo.setWriter(rs.getString("writer"));
				vo.setTitle(rs.getString("title"));
				vo.setSubject(rs.getString("subject"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setHit(rs.getInt("hit"));
				
				hitUpdate(vo.getId()); //조회수증가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close();
		}

		return null;
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		return 0;
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		return 0;
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		return 0;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void hitUpdate(int id) {
		String sql = "UPDATE NOTICE SET HIT = HIT + 1 WHERE ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
