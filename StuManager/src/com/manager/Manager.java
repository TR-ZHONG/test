package com.manager;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.bean.Student;

public class Manager {
	//单例，避免冲突 
	private static Manager mg = new Manager();
	private Manager() {}
		public static Manager getInstance() {
			return mg;
	}

	Scanner sc = new Scanner(System.in);
	Random rd =new Random();
	
	//初始化
	List<Student> st = Arrays.asList(
            new Student(1,"张三",rd.nextInt(16)+10,rd.nextInt(101)+20),
            new Student(2,"李四",rd.nextInt(16)+10,rd.nextInt(101)+20),
            new Student(3,"王五",rd.nextInt(16)+10,rd.nextInt(101)+20),
            new Student(4,"赵六",rd.nextInt(16)+10,rd.nextInt(101)+20)
    );
	
	//添加
	public void add(Student stu) {
		boolean flag = true;
		while(flag) {
		
			if (st.contains(stu)) {
				System.out.println("该同学已存在！！！");
				flag=false;
			}else {
				st.add(stu);
				System.out.println("添加成功");
			}
		}
	}

	//删除
	public void delstu(int id) {
			if (!st.contains(st.get(id))) {
				System.out.println("该同学不存在！！！");
			}else {
				st.remove(id);
				System.out.println("删除成功");
		}
	}
	
	//修改
	public void updatestu(int xu,Student stu) {
		selectstu();
		
		st.set(xu,stu);
		System.out.println("修改成功");
		for (Student student : st) {
			System.out.println(student);
		}
		
	}
	
	//查询所有
	public void selectstu() {
		Iterator<Student> ite = st.iterator();
		while(ite.hasNext()) {
			Student student = ite.next();
			System.out.println(student);
		}
	}
	
	//排序，
	public void sortstu() {
		//如果score一样就比较年龄
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
