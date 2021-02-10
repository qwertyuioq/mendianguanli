package com.zq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.DoorMapper;
import com.zq.pojo.Door;

//交给spring去创建实例，标识当前类属于service层
@Service
public class DoorServiceImpl implements DoorService {
	
	//表示当前类（或接口）的实例将有spring容器创建，并赋值给该变量
	@Autowired
	private DoorMapper dao;
	
	//查询所有门店
	@Override
	public List<Door> findAll() {
		List<Door> list = dao.findAll();
		return list;
	}

	//2.新增门店信息
	@Override
	public void addDoor(Door door) {
		dao.addDoor(door);
		
	}

	//3.根据id删除门店信息
	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
		
	}

	//4.根据id查出门店信息，然后修改
	@Override
	public Door findById(Integer id) {
		Door door=dao.findById(id);
		return door;
	}

	//5.根据id修改门店信息
	@Override
	public void updateById(Door door) {
		dao.updateById(door);
		
	}

}
