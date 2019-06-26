package edu.xawl.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import edu.xawl.mapper.UserMapper;
import edu.xawl.pojo.User;
import edu.xawl.utils.MyBatisUtil;

@Service
public class UserService {

	/**
	 * 验证密码和用户名是否存在
	 * @param tnumber 用户名
	 * @param tpassword 密码
	 * @return
	 */
	public String check_tnmb_tpwd(String tnumber, String tpassword) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		String name = userMapper.check_tnmb_tpwd(tnumber, tpassword);
		MyBatisUtil.close(sqlSession);
		return name;
	}

	public boolean upStept(User user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int i = userMapper.upStept(user);
		sqlSession.commit();
		MyBatisUtil.close(sqlSession);
		return i > 0;
	}

	public ArrayList<User> selDayRank(String tdate) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		ArrayList<User> dayRank  = new ArrayList<User>();
		dayRank = userMapper.selDayRank(tdate);
		MyBatisUtil.close(sqlSession);
		return dayRank;
	}

	public ArrayList<User> monthRank(String tdate) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		ArrayList<User> monthRank  = new ArrayList<User>();
		monthRank = userMapper.monthRank(tdate);
		MyBatisUtil.close(sqlSession);
		return monthRank;
	}

	public boolean userEditPwd(String tnumber, String tpassword, String newpwd) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		boolean result = false;
		String name = userMapper.check_tnmb_tpwd(tnumber, tpassword);
		if(!"".equals(name) && name.length() > 0 ){
			result = userMapper.userEditPwd(tnumber,tpassword,newpwd);
		}
		MyBatisUtil.close(sqlSession);
		return result;
	}
	
	

}
