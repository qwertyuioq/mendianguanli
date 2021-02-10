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
	
	//1.��ѯ���ж�����Ϣ
	@RequestMapping("/orderList")
	public String orderList(Model model){
		//���ò�ѯ�����ŵ�ķ���
		List<Door> dList = doorDao.findAll();
		model.addAttribute("dList", dList);
		//���ò�ѯ���ж����ķ���
		List<Order> oList = dao.findAll();
		model.addAttribute("oList", oList);
		//����������ת����order_list.jspҳ��
		return "order_list";
	}
	
	//2.1��ת����������ҳ��,Я�������ŵ���Ϣ����������ҳ��
		@RequestMapping("/toOrderAddPage")
		public String toOrderAddPage(Model model){
			//���ò�ѯ�����ŵ�ķ���
			List<Door> dList = doorDao.findAll();
			model.addAttribute("dList", dList);
			return "order_add";
		}
		
	//2.����������Ϣ
	@RequestMapping("/orderAdd")
	public String orderAdd(Order order){
		//�������������ķ���
		dao.addOrder(order);
		//ֱ�ӵ���doorList����ѯ�����ŵ���Ϣ
		return  "forward:/orderList";
	}
	
	//3.ɾ��������Ϣ
	@RequestMapping("/orderDelete")
	public String orderDelete(Integer id){
		dao.deleteById(id);
		//ֱ�ӵ���doorList����ѯ�����ŵ���Ϣ
		return  "forward:/orderList";
	}
	
	//4.����id��ѯ������Ϣ������ѯ������Ϣ���������޸�ҳ�棬�������ݻ��ԣ�
	//ͬʱ���轫�ŵ꼯�ϴ��������޸�ҳ�棬��ʾ�ŵ��б�
	@RequestMapping("/orderInfo")
	public String orderInfo(Integer id,Model model){
		Order order = dao.findById(id);
		model.addAttribute("order", order);
		//���ò�ѯ�����ŵ�ķ���
		List<Door> dList = doorDao.findAll();
		model.addAttribute("dList", dList);
		return "order_update";
	}
	
	//4.�޸Ķ�����Ϣ
	@RequestMapping("/orderUpdate")
	public String orderUpdate(Order order){
		//���ø���id�޸Ķ�����Ϣ�ķ���
		dao.updateById(order);
		//ֱ�ӵ���doorList����ѯ�����ŵ���Ϣ
		return  "forward:/orderList";
	}
}
