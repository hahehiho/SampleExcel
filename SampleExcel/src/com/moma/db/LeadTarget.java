package com.moma.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.moma.dbo.LeadTargetDO;

public class LeadTarget {

	public static void main(String[] args) throws IOException {
		String resource = "com/moma/db/dbconf.xml"; 
		InputStream inputStream = Resources.getResourceAsStream(resource); 
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<LeadTargetDO> leadTargetList = sqlSession.selectList("selectEnforTargetAll");
		for (LeadTargetDO leadTargetDO : leadTargetList) {
			System.out.println(leadTargetDO);
		}


	}

}
