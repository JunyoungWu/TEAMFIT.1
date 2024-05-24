package tf.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	public static Connection makeConnections() {
		String filePath = "D:/eclipse-workspace/TeamFitProject/src/db.properties";
		Connection con = null;
		try {
	        //db properties 데이터 가져오기
	  	  Properties  properties = new Properties();
	  	  try {
				properties.load(new FileReader(filePath));
			} catch (FileNotFoundException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
	  	  
	  	  String url = properties.getProperty("url");
	  	  String user = properties.getProperty("user");
	  	  String password = properties.getProperty("password");
	  	  // db loading
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        // db connect
	       // System.out.println("데이타베이스 드라이버 로드 성공");
	        con = DriverManager.getConnection(url,user,password);
	       // System.out.println("데이타베이스 접속 성공");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        System.out.println("데이타베이스 드라이버 로드 실패");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("데이타베이스 연결 실패");
	    }
	    return con;
	}
	
 }

