package com.zq.dao;

import java.util.List;

import com.zq.pojo.Order;

public interface OrderMapper {
	
	//��ѯ���ж���
		public List<Order> findAll();

		//2.����������Ϣ
		public void addOrder(Order order);

		//3.����idɾ��������Ϣ
		public void deleteById(Integer id);

		//4.����id���������Ϣ��Ȼ���޸�
		public Order findById(Integer id);

		//5.����id�޸Ķ�����Ϣ
		public void updateById(Order order);
	}

