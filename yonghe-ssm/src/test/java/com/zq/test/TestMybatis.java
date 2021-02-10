package com.zq.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zq.dao.DoorMapper;
import com.zq.pojo.Door;


//测试Mybatis的运行环境
public class TestMybatis {
	public static void main(String[] args) throws IOException {
		//读取配置文件,获得输入流
		InputStream in = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		//
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
	//
		SqlSession session = factory.openSession();
	//获取Mapper接口实现类的实例
		DoorMapper mapper = session.getMapper(DoorMapper.class);
		List<Door> list = mapper.findAll();
		for (Door door : list) {
			System.out.println(door);
		}
	}

}
