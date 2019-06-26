package edu.xawl.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import edu.xawl.pojo.User;
import edu.xawl.service.UserService;

@Controller
@RequestMapping("/userController")
public class UserController {
	
	@Autowired
	private UserService uService;
	Gson gson = new Gson();
	
	/**
	 * 用户登录 
	 * @param tnumber 用户名
	 * @param tpassword 密码
	 * @return 1登录成功 0 登录失败
	 */
	@RequestMapping("/userLogin")
	@ResponseBody
	public String userLogin(String tnumber, String tpassword){
		String tname = "";
		if (tnumber != null && tnumber.length() > 0 && tpassword != null && tpassword.length() > 0) {
			// 校验用户名和密码
			tname = uService.check_tnmb_tpwd(tnumber, tpassword);
		}
		if (tname != null && tname.length() > 0) {
			return "{\"login_status\":1, \"tname\":\"" + tname + "\"}";
		}else {
			return ("{\"login_status\":0}");
		}
	}
	
	/**
	 * 步数的新增和更新
	 * @param user
	 * @return
	 */
	@RequestMapping("/upStept")
	@ResponseBody
	public String upStept(User user){
		System.out.println(user);
		boolean result = uService.upStept(user);
		if (result) {
			return ("{\"up_status\":1}");
		}else {
			return ("{\"up_status\":0}");
		}	
	}
	
	/**
	 * 日排行
	 * @param tdate 查询的日期
	 */
	@RequestMapping("/dayRank")
	@ResponseBody
	public String dayRank(String tdate){
		Map<String, ArrayList<User>> rankMap = new HashMap<String, ArrayList<User>>();
		ArrayList<User> dayRank = uService.selDayRank(tdate);
		rankMap.put("dayRank", dayRank);
		// 将日排行信息返回
		return gson.toJson(rankMap);
	}
	
	/**
	 * 月排行
	 */
	@RequestMapping("/monthRank")
	@ResponseBody
	public String monthRank(String tdate){
		Map<String, ArrayList<User>> rankMap = new HashMap<String, ArrayList<User>>();
		ArrayList<User> monthRank = uService.monthRank(tdate.substring(0, 7));
		rankMap.put("monthRank", monthRank);
		return gson.toJson(rankMap);
	}
	
	/**
	 * 修改密码
	 */
	@RequestMapping("/userEditPwd")
	@ResponseBody
	public String userEditPwd(String tnumber,String tpassword, String newpwd){
		boolean result = uService.userEditPwd(tnumber,tpassword,newpwd);
		// 1表示注册成功;0表示注册失败
		if (result) {
			return ("{\"editPwd_status\":1}");
		}else {
			return ("{\"editPwd_status\":0}");
		}	
	}
	
}
