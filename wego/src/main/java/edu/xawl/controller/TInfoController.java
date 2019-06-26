package edu.xawl.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.xawl.pojo.Teacher;
import edu.xawl.service.TInfoService;

@RestController
@RequestMapping("/tInfoController")
public class TInfoController {
	
	@Autowired
	private TInfoService tService;
	/**
	 * 初始化页面
	 * @param page 本页第一条数据
	 * @param rows 本页显示的条数
	 * @return 数据集合
	 */
	@RequestMapping("/initTInfo")
	public Map<String, Object> initTInfo(Integer page, Integer rows, String tname) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", (page - 1) * rows);
		map.put("size", rows);
		map.put("tname",tname);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", tService.getCount());
		result.put("rows", tService.listPage(map));
		return result;
	}
	
	@RequestMapping("/add")
	public boolean add(Teacher teacher){
		return tService.add(teacher);
	}
	
	@RequestMapping("/remove")
	public boolean remove(@RequestParam("tNumbArr[]")int tNumbArr[]){
		return tService.remove(tNumbArr);
	}
	
	@RequestMapping("/edit")
	public boolean edit(Teacher teacher){
		return tService.edit(teacher);
	}

}
