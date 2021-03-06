package com.encore.control;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyBatisTest {
	
   //@Inject
   @Autowired//XML파일내에 일치하는 자료형이 존재한다면 자동 주입을 실행!!
   private SqlSessionFactory sessionFactory;
	
   @Test
   public void factoryTest() {
	  System.out.println("sessionFactory: "+ sessionFactory);   
   }
   
   @Test
   public void sqlSessionTest() {
	  SqlSession session =  sessionFactory.openSession();//SqlSession: XML내의 sql문 호출하는 객체
	  System.out.println("session: "+ session);
   }
}




