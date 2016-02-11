package com.moma.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.moma.ExcelToDB;
import com.moma.excel.ColumnInfo;

public class DBInsert {
	private Connection conn = null;
	private Statement stmt = null;
	private String url;
	private String id;
	private String pw;
	

	public DBInsert(String url, String id, String pw, String driver) throws ClassNotFoundException, SQLException {
		Class.forName(driver);                       // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.	
		this.url = url;
		this.id = id;
		this.pw = pw;
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
		if(conn == null) {
			resetConn();
		}
		
		conn.setAutoCommit(false);
		stmt = conn.createStatement();
	}

	private void resetConn() throws SQLException {
		conn = DriverManager.getConnection(url,id,pw);
	}

	public void commit() throws SQLException {
		conn.commit();
		stmt.clearBatch();
	}

	public void executeBatchInsert(String tableName, ColumnInfo[] columnInfo) throws SQLException {
		String query = "insert into " + tableName + "( ";
		
		boolean isFirst = true;
		for (int i = 0; i < columnInfo.length; i++ ){			
			if(columnInfo[i].type == ColumnInfo.TYPE_SKIP)
				continue;

			if(!isFirst)
				query += ",";

			query += columnInfo[i].dbColumn;
			isFirst = false;
		}
		
		query += ") values(";

		isFirst = true;
		for (int i = 0; i < columnInfo.length; i++ ){
			if(columnInfo[i].type == ColumnInfo.TYPE_SKIP)
				continue;

			if(!isFirst)
				query += ",";

			query += columnInfo[i].getQueryValue();
			isFirst = false;			
		}
		
		query += ");";

		System.out.println(query);
		
		stmt.addBatch(query);
	}

	public void close() {
		try {
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn = null;
			stmt = null;
		}
		
	}

	public void executeBatch() throws SQLException {
		int result[] = stmt.executeBatch();
		for(int i = 0; i < result.length; i++) {
			if(result[i] < 0) {
				System.out.println("fail " + i);
			}
		}
	}

	public void execute(String query) throws SQLException {
		Statement oneStmt = conn.createStatement();
		oneStmt.executeUpdate(query);
	}

}
