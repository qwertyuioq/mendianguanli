package com.zq.service;

import java.util.List;



import com.zq.pojo.Door;


public interface DoorService {
	//1.��ѯ�����ŵ���Ϣ
	public List<Door> findAll();

	//2.�����ŵ���Ϣ
	public void addDoor(Door door);

	//3.����idɾ���ŵ���Ϣ
	public void deleteById(Integer id);

	//4.����id����ŵ���Ϣ��Ȼ���޸�
	public Door findById(Integer id);

	//5.����id�޸��ŵ���Ϣ
	public void updateById(Door door);
}
