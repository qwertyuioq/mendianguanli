package com.zq.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zq.pojo.Door;

public class TestSpring {
	public static void main(String[] args) {
		//1.��ȡspring �������ļ�
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		//��ȡdoor���ʵ��
		Door door = (Door)ac.getBean("door");
		System.out.println(door);
	}

}
