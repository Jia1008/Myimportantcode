package com.briup.proxy;

//ʵ����
public class StudentServiceImpl implements IStudentService{

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		System.out.println("����һ��ѧ��");
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		System.out.println("ɾ��һ��ѧ��");
	}

	@Override
	public void update(Student studnet) {
		// TODO Auto-generated method stub
		System.out.println("����ѧ����Ϣ");
	}

}
