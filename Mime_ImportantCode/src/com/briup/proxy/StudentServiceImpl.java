package com.briup.proxy;

//实现类
public class StudentServiceImpl implements IStudentService{

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		System.out.println("增加一个学生");
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		System.out.println("删除一个学生");
	}

	@Override
	public void update(Student studnet) {
		// TODO Auto-generated method stub
		System.out.println("更新学生信息");
	}

}
