package com.zq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.DoorMapper;
import com.zq.pojo.Door;

//����springȥ����ʵ������ʶ��ǰ������service��
@Service
public class DoorServiceImpl implements DoorService {
	
	//��ʾ��ǰ�ࣨ��ӿڣ���ʵ������spring��������������ֵ���ñ���
	@Autowired
	private DoorMapper dao;
	
	//��ѯ�����ŵ�
	@Override
	public List<Door> findAll() {
		List<Door> list = dao.findAll();
		return list;
	}

	//2.�����ŵ���Ϣ
	@Override
	public void addDoor(Door door) {
		dao.addDoor(door);
		
	}

	//3.����idɾ���ŵ���Ϣ
	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
		
	}

	//4.����id����ŵ���Ϣ��Ȼ���޸�
	@Override
	public Door findById(Integer id) {
		Door door=dao.findById(id);
		return door;
	}

	//5.����id�޸��ŵ���Ϣ
	@Override
	public void updateById(Door door) {
		dao.updateById(door);
		
	}

}
