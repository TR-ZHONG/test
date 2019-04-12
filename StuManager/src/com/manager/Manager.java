package com.manager;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.bean.Student;

public class Manager {
	//�����������ͻ 
	private static Manager mg = new Manager();
	private Manager() {}
		public static Manager getInstance() {
			return mg;
	}

	Scanner sc = new Scanner(System.in);
	Random rd =new Random();
	
	//��ʼ��
	List<Student> st = Arrays.asList(
            new Student(1,"����",rd.nextInt(16)+10,rd.nextInt(101)+20),
            new Student(2,"����",rd.nextInt(16)+10,rd.nextInt(101)+20),
            new Student(3,"����",rd.nextInt(16)+10,rd.nextInt(101)+20),
            new Student(4,"����",rd.nextInt(16)+10,rd.nextInt(101)+20)
    );
	
	//���
	public void add(Student stu) {
		boolean flag = true;
		while(flag) {
		
			if (st.contains(stu)) {
				System.out.println("��ͬѧ�Ѵ��ڣ�����");
				flag=false;
			}else {
				st.add(stu);
				System.out.println("��ӳɹ�");
			}
		}
	}

	//ɾ��
	public void delstu(int id) {
			if (!st.contains(st.get(id))) {
				System.out.println("��ͬѧ�����ڣ�����");
			}else {
				st.remove(id);
				System.out.println("ɾ���ɹ�");
		}
	}
	
	//�޸�
	public void updatestu(int xu,Student stu) {
		selectstu();
		
		st.set(xu,stu);
		System.out.println("�޸ĳɹ�");
		for (Student student : st) {
			System.out.println(student);
		}
		
	}
	
	//��ѯ����
	public void selectstu() {
		Iterator<Student> ite = st.iterator();
		while(ite.hasNext()) {
			Student student = ite.next();
			System.out.println(student);
		}
	}
	
	//����
	public void sortstu() {
		//���scoreһ���ͱȽ�����
		st.stream().sorted((x,y)->{
			if (x.getScore() - y.getScore() > 0){
		         return 1;
		    }
		    if (x.getScore() - y.getScore() < 0){
		         return -1;
		    }else if (x.getScore() - y.getScore() ==0){
		          st.stream().
		        		 map(e->e.getAge()).
		        		 sorted().
		        		 forEach(System.out::println);
		    }
		    return 0;
		}).forEach(System.out::println);
	}
}
