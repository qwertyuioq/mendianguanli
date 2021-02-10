package com.zq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zq.dao.DoorMapper;
import com.zq.pojo.Door;


//测试ssm开发环境
@Controller
public class testSSM {
	@Autowired//自动装配，幽spring容器创建该类（或接口）的实例，并赋值给当前变量
	private DoorMapper mapper;
	
	@RequestMapping("/testSSM")
	public String testSSM(Model model){
		//查询所有门店信息
		List<Door> list = mapper.findAll();
		//将所有门店的集合存入Model中
		model.addAttribute("list", list);
		return "door_list";
	}
}
