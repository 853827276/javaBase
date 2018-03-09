package com.zh;

/**
 * student 实体类
 * 
 * @author zhangh
 *
 */
public class Student {

	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student() {
		System.out.print("默认的无参数构造方法！");
	}

	public Student(Integer id, String name) {
		this.id = id;
		this.name = name;
		System.out.print("自定义的有参构造方法！");
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

	private Student(int a, int b) {
		System.out.println("私有的构造方法!");
	}

	public void method() {
		System.out.print("自定义的public 方法");
	}

	public String method1(String str) {
		System.out.println("自定义的public 方法1,方法参数：" + str);
		return "我是method1 的返回值";
	}

	private void method2() {
		System.out.print("自定义的private 方法2");
	}

	void method3() {
		System.out.print("默认的方法3");
	}

	public static void main(String[] args) {
		System.out.println("我是main方法");
	}
}
