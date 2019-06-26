package edu.xawl.mapper;

import java.util.List;
import java.util.Map;

import edu.xawl.pojo.Teacher;

public interface TeacherMapper {

	int getCount();

	List<Teacher> listPage(Map<String, Object> map);

	boolean add(Teacher teacher);

	boolean remove(int[] tNumbArr);

	boolean edit(Teacher teacher);

}
