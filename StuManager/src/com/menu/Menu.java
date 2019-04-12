package com.menu;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import com.bean.Student;
import com.manager.Manager;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	
	
	/**
	 * 启动
	 * @throws FileNotFoundException 
	 */
	public void start() throws FileNotFoundException {
		System.out.println("欢迎来到学生管理系统.");
		while (true) {
			System.out.println("您可以进行一下操作: 1,添加,2,删除，3,修改，4,查询，5,排序");
			String command = scanner.nextLine();

			switch (command) {
			// 添加
			case "1":
				System.out.println("请输入学生信息：");
				try {
					System.out.println("id：");
					int id = scanner.nextInt();
					System.out.println("name：");
					String name = scanner.next();
					System.out.println("age：");
					int age = scanner.nextInt();
					System.out.println("score：");
					int score = scanner.nextInt();
					Manager.getInstance().add(new Student(id,name,age,score));
				} catch (Exception e1) {
					//异常信息保存到log.txt
					e1.printStackTrace(new PrintStream("src/log.txt"));
				}
				break;
			case "2":
				System.out.println("请输入要删除学生id：");
				try {
					int id1 = scanner.nextInt();
					Manager.getInstance().delstu(id1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;	
			case "3":
				System.out.println("请输入要修改学生的序号：");
				try {
					int xu = scanner.nextInt();
					System.out.println("请输入要修gai的id：");
					int id2 = scanner.nextInt();
					System.out.println("请输入要修gai的name：");
					String name2 = scanner.next();
					System.out.println("请输入要修gai的age：");
					int age2 = scanner.nextInt();
					System.out.println("请输入要修gai的score：");
					int score2 = scanner.nextInt();
					Manager.getInstance().updatestu(xu,new Student(id2, name2, age2, score2));
				} catch (Exception e) {
					//异常信息保存到log.txt
					e.printStackTrace(new PrintStream("src/log.txt"));
				}
				break;	
			case "4":
				Manager.getInstance().selectstu();
				break;	
			case "5":
				Manager.getInstance().sortstu();
				break;	
			default:
				break;
		}
	}
  }
}