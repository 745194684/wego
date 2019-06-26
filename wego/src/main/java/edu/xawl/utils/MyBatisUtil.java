package edu.xawl.utils;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil{

	private static SqlSessionFactory   factory=null;

	static{
		try {
			Reader reader=Resources.getResourceAsReader("mybatis.xml");
			factory=	new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	
	public static SqlSession  getSqlSession(){
		return factory.openSession();
	}
	
	public static void close(SqlSession  sqlSession){
		if(sqlSession!=null){
			sqlSession.close();
		}
	}

}
