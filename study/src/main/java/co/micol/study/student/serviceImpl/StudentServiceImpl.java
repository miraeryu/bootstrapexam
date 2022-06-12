package co.micol.study.student.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.study.comm.DataSource;
import co.micol.study.student.service.StudentMapper;
import co.micol.study.student.service.StudentService;
import co.micol.study.student.vo.StudentVO;

public class StudentServiceImpl implements StudentService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true); // 오토커밋
	private StudentMapper map = sqlSession.getMapper(StudentMapper.class);
			
	@Override
	public List<StudentVO> studentSelectList() {
		return map.studentSelectList();
	}

	@Override
	public StudentVO studentSelect(StudentVO vo) {
		return map.studentSelect(vo);
	}

	@Override
	public int studentInsert(StudentVO vo) {
		return map.studentInsert(vo);
	}

	@Override
	public int studentUpdate(StudentVO vo) {
		return map.studentUpdate(vo);
	}

	@Override
	public int studentDelete(StudentVO vo) {
		return map.studentDelete(vo);
	}

}
