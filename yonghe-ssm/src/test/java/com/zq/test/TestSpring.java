package com.zq.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zq.pojo.Door;

public class TestSpring {
	public static void main(String[] args) {
		//1.读取spring 的配置文件
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		//获取door类的实例
		Door door = (Door)ac.getBean("door");
		System.out.println(door);
	}

}
