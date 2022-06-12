package com.micol.student.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.micol.notice.dao.DataSource;
import com.micol.student.dto.StudentVO;
import com.micol.student.service.StudentService;

public class StudentServiceImpl implements StudentService{
	private DataSource dataSource = DataSource.getInstance(); //Dao instance 생성
	private Connection conn = dataSource.getConnection(); //connection
	private PreparedStatement psmt; //sql 명령실행
	private ResultSet rs; //select 결과를 담음
	

	@Override
	public List<StudentVO> selectListStudent() {//전체 학생 목록
		List<StudentVO> students = new ArrayList<StudentVO>();
		StudentVO student;
		//sql구문
		String sql = "SELECT * FROM STUDENT"; //cntl+shif+x로 대문자 전환
		try {
			psmt = conn.prepareStatement(sql); //sql문을 보냄
			rs = psmt.executeQuery(); //명령을 실행시키고 결과를 담음
			while(rs.next()) {
				student = new StudentVO(); //초기화 시키는 것 우선
				student.setStudentId(rs.getString("studentid"));
				student.setName(rs.getString("name"));
				student.setBirthday(rs.getDate("birthday"));
				student.setMajor(rs.getString("major"));
				student.setAddress(rs.getString("address"));
				student.setTel(rs.getString("tel"));
				students.add(student);//리스트 추가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public StudentVO selectStudentVO(StudentVO student) {//학생 1명 목록
		StudentVO student1 = new StudentVO();
		String sql = "select * from student where studentid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId()); //대입문장, (n번째 물을표에, 해당내용을 대입) set(타입)
			rs = psmt.executeQuery();
			if(rs.next()) {
				student1.setStudentId(rs.getString("studentid"));
				student1.setName(rs.getString("name"));
				student1.setBirthday(rs.getDate("birthday"));
				student1.setMajor(rs.getString("major"));
				student1.setAddress(rs.getString("address"));
				student1.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student1;
	}

	@Override
	public int insertStudent(StudentVO student) {//학생 추가
		int n = 0;
		String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId());
			psmt.setString(2, student.getName());
			psmt.setDate(3, student.getBirthday());
			psmt.setString(4, student.getMajor());
			psmt.setString(5, student.getAddress());
			psmt.setString(6, student.getTel());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int updateStudent(StudentVO student) {//학생 갱신
		int n = 0;
		String sql = "UPDATE STUDENT SET MAJOR = ?,"
				+ " ADDRESS = ?, TEL = ? WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getMajor());
			psmt.setString(2, student.getAddress());
			psmt.setString(3, student.getTel());
			psmt.setString(4, student.getStudentId());
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int deleteStudent(StudentVO student) {//학생 삭제
		int n = 0;
		String sql = "DELETE FROM STUDENT WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId());
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

}
