package com.moma.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.moma.ExcelToDB;

public class DBInsert {
	private Connection conn = null;

	public DBInsert(String url, String id, String pw, String driver) throws ClassNotFoundException, SQLException {
		Class.forName(driver);                       // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.	
		conn = DriverManager.getConnection(url,id,pw);   
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/adsk";        // 사용하려는 데이터베이스명을 포함한 URL 기술
		String id = "bgcho98";                                                    // 사용자 계정
		String pw = "2417bgbg";                                                // 사용자 계정의 패스워드

		Class.forName("com.mysql.jdbc.Driver");                       // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.
		Connection conn = DriverManager.getConnection(url,id,pw);   
		
		
	}

	public void beginTransaction() throws SQLException {
		conn.setAutoCommit(false);
	}

	public void commit() throws SQLException {
		conn.commit();
	}

}
