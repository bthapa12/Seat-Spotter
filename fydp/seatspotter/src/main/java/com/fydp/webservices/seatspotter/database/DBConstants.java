package com.fydp.webservices.seatspotter.database;

public class DBConstants {
	
	// Connection informations
	public static final String dbClass ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//public static final String dbName ="SeatSpotterDev";
	public static final String dbName ="SeatSpotterDB";
	//public static final String dbUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName="+dbName;
	public static final String dbUrl = "jdbc:sqlserver://seatspotterdb.database.windows.net:1433;database="+dbName;
	//public static final String dbUser = "SeatSpotterPublic";
	public static final String dbUser = "seatspotteradmin@seatspotterdb";
	//public static final String dbPwd = "FYDP2015";	
	public static final String dbPwd = "S3atsP0tt3r";
	
	// READ Store Procedure mapping
	public static final String GET_LIBRARIES = "ap_GetLibrariesWithDesks";
	public static final String GET_LIBRARYBYID = "ap_GetLibrary(?)";
	public static final String GET_FLOORS = "ap_GetFloorsWithDesks(?)";
	public static final String GET_FLOORSBYID = "ap_GetFloor(?,?)";
	public static final String GET_DESKHUBS = "ap_GetDeskHubWithDesks(?)";
	public static final String GET_DESKHUBSBYID = "ap_GetDeskHub(?,?)";
	public static final String GET_DESKS = "ap_GetDesks(?)";
	public static final String GET_DESKSBYID = "ap_GetDesk(?,?)";

	// WRITE Store Procedure mapping
	public static final String UPDATE_LIBRARY = "wp_UpdateLibrary(?,?)";
	public static final String UPDATE_FLOOR = "wp_UpdateLibraryFloor(?,?,?)";
	public static final String UPDATE_DESKHUB_LOCATION = "wp_UpdateDeskHubLocation(?)";
	public static final String UPDATE_DESK_LOCATION = "wp_UpdateDeskLocation(?)";
	public static final String UPDATE_DESK_STATE = "wp_UpdateDeskState(?)";
	
	public static final String INSERT_DESK = "wp_InsertDesk(?,?,?,?)";
	public static final String INSERT_DESKHUB = "wp_InsertDeskHub(?,?,?)";
	public static final String INSERT_FLOOR = "wp_InsertFloor(?,?)";
	public static final String INSERT_LIBRARY = "wp_InsertLibrary(?)";
}
