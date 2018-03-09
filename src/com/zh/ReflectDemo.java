package com.zh;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class ReflectDemo {


	@Test
	public void test3() throws Exception {
		// 1 加载反射
		// System.out.println(s.getClass().getName());
		// System.out.println(Student.class.getName());
		// System.out.println(Class.forName("com.zh.Student").getName());
		// 2获取类的构造方法
		for (Constructor c : Student.class.getDeclaredConstructors()) {
			System.out.println("构造方法：" + c);
		}
		System.out.println("输出默认的构造方法：" + Student.class.getConstructor());
		System.out.println("调用方法生成一个对象："
				+ Student.class.getConstructor().newInstance());
		// 3 获取成员
		for (Field field : Student.class.getDeclaredFields()) {
			System.out.println("成员变量：" + field);
		}
		System.out.println("获取单个name成员变量："
				+ Student.class.getDeclaredField("name"));
		System.out
				.println("获取单个id成员变量：" + Student.class.getDeclaredField("id"));
		// 4 给成员赋值
		Student student = Student.class.getConstructor().newInstance();// 默认一个实例，相当于
																		// new
																		// Student();
		Field FieldId = Student.class.getDeclaredField("id");
		FieldId.setAccessible(true);
		FieldId.set(student, 1);
		Field FieldName = Student.class.getDeclaredField("name");
		FieldName.setAccessible(true);
		FieldName.set(student, "zhangheng_测试反射");
		System.out.println("修改的对象实例:" + student);
		// 5获取方法
		for (Method method : Student.class.getDeclaredMethods()) {
			System.out.println("方法 ：" + method);
		}
		// 获取指定的方法（根据方法名反色获取）
		System.out.println("toString 方法："
				+ Student.class.getDeclaredMethod("toString", null));
		System.out.println("method1 方法："
				+ Student.class.getDeclaredMethod("method1", String.class));
		// 反射调用方法
		Method method1Method = Student.class.getDeclaredMethod("method1",
				String.class);
		method1Method.setAccessible(true);
		Object obj = method1Method.invoke(student, "我是反射方法method1 的参数值 ");// 调用方法
																			// 返回的是方法的返回值
		System.out.println("反射调用方法返回：" + obj);
		// main 方法的反射调用
		method1Method = Student.class.getDeclaredMethod("main", String[].class);
		method1Method.setAccessible(true);
		// 第一个参数，对象类型，因为方法是static静态的，所以为null可以，第二个参数是String数组
		// obj = method1Method.invoke(student,(Object)new
		// String[]{"a","b","c"});//调用方法 返回的是方法的返回值
		obj = method1Method.invoke(student, new Object[] { new String[] { "a",
				"b", "c" } });// 调用方法 返回的是方法的返回值
		System.out.println("反射调用main方法返回：" + obj);
	}
}
