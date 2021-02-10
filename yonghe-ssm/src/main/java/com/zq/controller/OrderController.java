package com.zq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zq.dao.DoorMapper;
import com.zq.dao.OrderMapper;
import com.zq.pojo.Door;
import com.zq.pojo.Order;

@Controller
public class OrderController {

	@Autowired
	private OrderMapper dao;
	
	@Autowired
	private DoorMapper doorDao;
	
	//1.查询所有订单信息
	@RequestMapping("/orderList")
	public String orderList(Model model){
		//调用查询所有门店的方法
		List<Door> dList = doorDao.findAll();
		model.addAttribute("dList", dList);
		//调用查询所有订单的方法
		List<Order> oList = dao.findAll();
		model.addAttribute("oList", oList);
		//将订单集合转发到order_list.jsp页面
		return "order_list";
	}
	
	//2.1跳转到订单新增页面,携带所有门店信息到订单新增页面
		@RequestMapping("/toOrderAddPage")
		public String toOrderAddPage(Model model){
			//调用查询所有门店的方法
			List<Door> dList = doorDao.findAll();
			model.addAttribute("dList", dList);
			return "order_add";
		}
		
	//2.新增订单信息
	@RequestMapping("/orderAdd")
	public String orderAdd(Order order){
		//调用新增订单的方法
		dao.addOrder(order);
		//直接调用doorList，查询所有门店信息
		return  "forward:/orderList";
	}
	
	//3.删除订单信息
	@RequestMapping("/orderDelete")
	public String orderDelete(Integer id){
		dao.deleteById(id);
		//直接调用doorList，查询所有门店信息
		return  "forward:/orderList";
	}
	
	//4.根据id查询订单信息，将查询到的信息带到订单修改页面，经行数据回显，
	//同时还需将门店集合带到顶顶修改页面，显示门店列表
	@RequestMapping("/orderInfo")
	public String orderInfo(Integer id,Model model){
		Order order = dao.findById(id);
		model.addAttribute("order", order);
		//调用查询所有门店的方法
		List<Door> dList = doorDao.findAll();
		model.addAttribute("dList", dList);
		return "order_update";
	}
	
	//4.修改订单信息
	@RequestMapping("/orderUpdate")
	public String orderUpdate(Order order){
		//调用根据id修改订单信息的方法
		dao.updateById(order);
		//直接调用doorList，查询所有门店信息
		return  "forward:/orderList";
	}
}
