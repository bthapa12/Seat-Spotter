package com.fydp.webservices.seatspotter.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DBManager {
	
	public static ResultSet executeProcedureWithNoParam(String procName){
		
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String pSql = "{call " + procName + "}";
			Statement stmt = dbConn.createStatement();
			return stmt.executeQuery(pSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ResultSet executeProcedureWithParam(String procName, List<Integer> params){
		
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			PreparedStatement pstmt = dbConn.prepareStatement("{call " + procName + "}");
			for (int i = 0; i < params.size(); i++){
				pstmt.setInt(i+1, params.get(i));
			}
			return pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
