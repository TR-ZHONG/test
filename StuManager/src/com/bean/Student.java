package com.bean;


public class Student {
	private int id;
	private String name;
	private int age;
	private int Score;
	
	public Student() {
		super();
	}
	
	public Student(int id, String name, int age, int score) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		Score = score;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Score;
		result = prime * result + age;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (Score != other.Score)
			return false;
		if (age != other.age)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", Score=" + Score + "]";
	}
	
	
}
