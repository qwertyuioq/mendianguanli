package com.zq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zq.dao.DoorMapper;
import com.zq.pojo.Door;


//����ssm��������
@Controller
public class testSSM {
	@Autowired//�Զ�װ�䣬��spring�����������ࣨ��ӿڣ���ʵ��������ֵ����ǰ����
	private DoorMapper mapper;
	
	@RequestMapping("/testSSM")
	public String testSSM(Model model){
		//��ѯ�����ŵ���Ϣ
		List<Door> list = mapper.findAll();
		//�������ŵ�ļ��ϴ���Model��
		model.addAttribute("list", list);
		return "door_list";
	}
}
