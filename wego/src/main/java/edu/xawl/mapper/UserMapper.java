package edu.xawl.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import edu.xawl.pojo.User;

public interface UserMapper {

	String check_tnmb_tpwd(@Param("tnumber") String tnumber, @Param("tpassword") String tpassword);

	int upStept(User user);

	ArrayList<User> selDayRank(String tdate);

	ArrayList<User> monthRank(String tdate);

	boolean userEditPwd(String tnumber, String tpassword, String newpwd); 

}
