package edu.xawl.service;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import edu.xawl.mapper.TeacherMapper;
import edu.xawl.pojo.Teacher;
import edu.xawl.utils.MyBatisUtil;

@Service
public class TInfoService {

	public int getCount() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		TeacherMapper dao = sqlSession.getMapper(TeacherMapper.class);
		int count = dao.getCount();
		return count;
	}

	public java.util.List<Teacher> listPage(Map<String, Object> map) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		TeacherMapper dao = sqlSession.getMapper(TeacherMapper.class);
		java.util.List<Teacher> tList = new ArrayList<Teacher>();
		tList = dao.listPage(map);
		MyBatisUtil.close(sqlSession);
		return tList;
	}

	public boolean add(Teacher teacher) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		TeacherMapper dao = sqlSession.getMapper(TeacherMapper.class);
		boolean result = dao.add(teacher);
		sqlSession.commit();
		MyBatisUtil.close(sqlSession);
		return result;
	}

	public boolean remove(int tNumbArr[]) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		TeacherMapper dao = sqlSession.getMapper(TeacherMapper.class);
		boolean result = dao.remove(tNumbArr);
		sqlSession.commit();
		MyBatisUtil.close(sqlSession);
		return result;
	}

	public boolean edit(Teacher teacher) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		TeacherMapper dao = sqlSession.getMapper(TeacherMapper.class);
		boolean result = dao.edit(teacher);
		sqlSession.commit();
		MyBatisUtil.close(sqlSession);
		return result;
	}

}
