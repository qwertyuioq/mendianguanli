package com.zq.service;

import java.util.List;



import com.zq.pojo.Door;


public interface DoorService {
	//1.查询所有门店信息
	public List<Door> findAll();

	//2.新增门店信息
	public void addDoor(Door door);

	//3.根据id删除门店信息
	public void deleteById(Integer id);

	//4.根据id查出门店信息，然后修改
	public Door findById(Integer id);

	//5.根据id修改门店信息
	public void updateById(Door door);
}
