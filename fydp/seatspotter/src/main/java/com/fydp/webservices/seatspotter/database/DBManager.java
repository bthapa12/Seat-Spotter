package com.fydp.webservices.seatspotter.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DBManager {
	
	public static ResultSet selectProcedureWithNoParam(String procName){
		
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
	
	public static ResultSet selectProcedureWithParam(String procName, List<Integer> params){
		
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
	
	public static ResultSet insertLibrary(String procName, String libraryName){
		
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			PreparedStatement pstmt = dbConn.prepareStatement("{call " + procName + "}");
			pstmt.setString(0, libraryName);
			return pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ResultSet insertFloor (String procName, int libraryId, String floorLevel) {
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			PreparedStatement pstmt = dbConn.prepareStatement("{call " + procName + "}");
			pstmt.setInt(1, libraryId);
			pstmt.setString(2, floorLevel);
			return pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ResultSet updateLibrary(String procName, int libraryId, String libraryName){
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			PreparedStatement pstmt = dbConn.prepareStatement("{call " + procName + "}");
			pstmt.setInt(1, libraryId);
			pstmt.setString(2, libraryName);
			return pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ResultSet updateFloor(String procName, int floorId, int libraryId, String floorLevel){
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			PreparedStatement pstmt = dbConn.prepareStatement("{call " + procName + "}");
			pstmt.setInt(1, floorId);
			pstmt.setInt(2, libraryId);
			pstmt.setString(3, floorLevel);
			return pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public static ResultSet deleteResource(String procName, int resourceId){
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			PreparedStatement pstmt = dbConn.prepareStatement("{call " + procName + "}");
			pstmt.setInt(1, resourceId);
			return pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int updateDeskState(String procName, int deskId, int deskState){
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			PreparedStatement pstmt = dbConn.prepareStatement("{call " + procName + "}");
			pstmt.setInt(1, deskId);
			pstmt.setInt(2, deskState);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

}
