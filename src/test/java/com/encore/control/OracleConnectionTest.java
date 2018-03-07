package com.encore.control;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class OracleConnectionTest {
	
	@Test//�����׽�Ʈ �ϰ��� �ϴ� �޼ҵ�
    public void testConnection() throws Exception{ 
    	Class.forName("oracle.jdbc.driver.OracleDriver");
    	//try(�ڵ� �ڿ���ȯ �� Ŭ����){} ===> finally{�ڿ���ȯ}�ڵ� ���� ����
    	try(Connection conn = 
    	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger")){
    		    
    		System.out.println("���Ἲ��!!"+ conn);
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    
    }//testConnection
}
