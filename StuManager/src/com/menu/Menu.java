package com.menu;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import com.bean.Student;
import com.manager.Manager;

public class Menu {
	private Scanner scanner = new Scanner(System.in);
	
	
	/**
	 * ����
	 * @throws FileNotFoundException 
	 */
	public void start() throws FileNotFoundException {
		System.out.println("��ӭ����ѧ������ϵͳ.");
		while (true) {
			System.out.println("�����Խ���һ�²���: 1,���,2,ɾ����3,�޸ģ�4,��ѯ��5,����");
			String command = scanner.nextLine();

			switch (command) {
			// ���
			case "1":
				System.out.println("������ѧ����Ϣ��");
				try {
					System.out.println("id��");
					int id = scanner.nextInt();
					System.out.println("name��");
					String name = scanner.next();
					System.out.println("age��");
					int age = scanner.nextInt();
					System.out.println("score��");
					int score = scanner.nextInt();
					Manager.getInstance().add(new Student(id,name,age,score));
				} catch (Exception e1) {
					//�쳣��Ϣ���浽log.txt
					e1.printStackTrace(new PrintStream("src/log.txt"));
				}
				break;
			case "2":
				System.out.println("������Ҫɾ��ѧ��id��");
				try {
					int id1 = scanner.nextInt();
					Manager.getInstance().delstu(id1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;	
			case "3":
				System.out.println("������Ҫ�޸�ѧ������ţ�");
				try {
					int xu = scanner.nextInt();
					System.out.println("������Ҫ��gai��id��");
					int id2 = scanner.nextInt();
					System.out.println("������Ҫ��gai��name��");
					String name2 = scanner.next();
					System.out.println("������Ҫ��gai��age��");
					int age2 = scanner.nextInt();
					System.out.println("������Ҫ��gai��score��");
					int score2 = scanner.nextInt();
					Manager.getInstance().updatestu(xu,new Student(id2, name2, age2, score2));
				} catch (Exception e) {
					//�쳣��Ϣ���浽log.txt
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