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

//�ŵ����ģ��
@Controller
public class DoorController {
	@Autowired//�Զ�װ�䣬��spring�����������ࣨ��ӿڣ���ʵ��������ֵ����ǰ����
	private DoorService service;
	
	//1.��ѯ�����ŵ���Ϣ
	@RequestMapping("/doorList")
	public String doorList(Model model){
		//��ѯ�����ŵ���Ϣ
		List<Door> list = service.findAll();
		//�������ŵ�ļ��ϴ���Model��
		model.addAttribute("list", list);
		return "door_list";
	}
	
	//2.�����ŵ���Ϣ
		@RequestMapping("/doorAdd")
		public String doorAdd(Door door,Model model){
			//����service��������ŵ귽��
			service.addDoor(door);
			//ֱ�ӵ���doorList����ѯ�����ŵ���Ϣ
			return doorList(model);
			//��ת��return  "forward:/doorlist"
			//���ض���return  "redirect:/doorlist"
		}
	
		//3.����idɾ���ŵ���Ϣ
		@RequestMapping("/doorDelete")
		public String doorDelete(Integer id){
			//����service���ɾ���ŵ귽��
			service.deleteById(id);
			//ֱ�ӵ���doorList����ѯ�����ŵ���Ϣ
			return  "forward:/doorList";
		}
		
		//4.����id����ŵ���Ϣ��Ȼ���޸�
		@RequestMapping("/doorInfo")
		public String doorInfo(Integer id,Model model){
			//����service��ĸ���id��ѯ�ŵ�����ķ���
			Door door=service.findById(id);
			//���ŵ�������model��
			model.addAttribute("door",door);
			return  "door_update";
		}
		
		//5.����id�޸��ŵ���Ϣ
		@RequestMapping("/doorUpdate")
		public String doorUpdate(Door door){
			//����service��ĸ���id�޸��ŵ�ķ���
			service.updateById(door);
			
			//��ʽ�����ض���doorList����ѯ�����ŵ���Ϣ
			return  "redirect:/doorList";
		}
		
		//ͨ�õ�ҳ����ת����
		//����û����ʵ�·��Ϊ��/index����pageֵ��Ϊindex
		@RequestMapping("/{page}")
		public String page(@PathVariable String page){

			return page;
		}
}
