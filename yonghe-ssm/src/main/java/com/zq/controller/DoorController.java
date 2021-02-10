package com.zq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zq.dao.DoorMapper;
import com.zq.pojo.Door;
import com.zq.service.DoorService;

//门店管理模块
@Controller
public class DoorController {
	@Autowired//自动装配，幽spring容器创建该类（或接口）的实例，并赋值给当前变量
	private DoorService service;
	
	//1.查询所有门店信息
	@RequestMapping("/doorList")
	public String doorList(Model model){
		//查询所有门店信息
		List<Door> list = service.findAll();
		//将所有门店的集合存入Model中
		model.addAttribute("list", list);
		return "door_list";
	}
	
	//2.新增门店信息
		@RequestMapping("/doorAdd")
		public String doorAdd(Door door,Model model){
			//调用service层的新增门店方法
			service.addDoor(door);
			//直接调用doorList，查询所有门店信息
			return doorList(model);
			//或转发return  "forward:/doorlist"
			//或重定向return  "redirect:/doorlist"
		}
	
		//3.根据id删除门店信息
		@RequestMapping("/doorDelete")
		public String doorDelete(Integer id){
			//调用service层的删除门店方法
			service.deleteById(id);
			//直接调用doorList，查询所有门店信息
			return  "forward:/doorList";
		}
		
		//4.根据id查出门店信息，然后修改
		@RequestMapping("/doorInfo")
		public String doorInfo(Integer id,Model model){
			//调用service层的根据id查询门店详情的方法
			Door door=service.findById(id);
			//将门店对象存入model中
			model.addAttribute("door",door);
			return  "door_update";
		}
		
		//5.根据id修改门店信息
		@RequestMapping("/doorUpdate")
		public String doorUpdate(Door door){
			//调用service层的根据id修改门店的方法
			service.updateById(door);
			
			//方式三，重定向doorList，查询所有门店信息
			return  "redirect:/doorList";
		}
		
		//通用的页面跳转方法
		//如果用户访问的路径为·/index，则page值就为index
		@RequestMapping("/{page}")
		public String page(@PathVariable String page){

			return page;
		}
}
