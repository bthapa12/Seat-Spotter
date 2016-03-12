package com.fydp.webservices.seatspotter.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fydp.webservices.seatspotter.database.DBConstants;
import com.fydp.webservices.seatspotter.database.DBManager;
import com.fydp.webservices.seatspotter.database.model.DeskHub;
import com.fydp.webservices.seatspotter.database.model.DeskHubWithDesk;
import com.fydp.webservices.seatspotter.database.model.LibraryWithDesk;

@Path("/floors/{floorId}/deskhubs")
public class RestApiDeskHubs {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//public List<DeskHubWithDesk> getDeskHubs(@PathParam("floorId") int floorId){
	public Response getDeskHubs(@PathParam("floorId") int floorId){
		ResultSet result;
		List<DeskHubWithDesk> deskHubs = new ArrayList<DeskHubWithDesk>();
		
		// setup params for stored procedure
		List<Integer> params = new ArrayList<Integer>();
		params.add(floorId);
		
		result = DBManager.selectProcedureWithParam(DBConstants.GET_DESKHUBS, params);
		
		try{
			while (result.next()){
				int deskHubId = result.getInt("DeskHubId");
				int libraryFloorId = result.getInt("LibraryFloorID");
				int coordinateX = result.getInt("CoordinateX");
				int coordinateY = result.getInt("CoordinateY");
				int lengthX = result.getInt("LengthX");
				int lengthY = result.getInt("LengthY");
				int totalDesks = result.getInt("TotalDesks");
				int emptyDesks = result.getInt("EmptyDesks");
				int unknownState = result.getInt("UnknownState");
				
				deskHubs.add(new DeskHubWithDesk(deskHubId, 
							libraryFloorId, 
							coordinateX, 
							coordinateY,
							lengthX,
							lengthY,
							totalDesks,
							emptyDesks,
							unknownState));
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
		GenericEntity<List<DeskHubWithDesk>> entity = new GenericEntity<List<DeskHubWithDesk>>(deskHubs){};
		return Response.ok()
				.entity(entity)
				.header("Access-Control-Allow-Origin", "*")
				.header("Acess-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS")
				.build();
	}
	
	
	@GET
	@Path("/{deskHubId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDeskHub(@PathParam ("floorId") int libraryFloorId, @PathParam("deskHubId") int deskHubId){
		
		ResultSet result;
		
		List<Integer> params = new ArrayList<Integer>();
		params.add(libraryFloorId);
		params.add(deskHubId);
		
		result = DBManager.selectProcedureWithParam(DBConstants.GET_DESKHUBSBYID, params);
		
		try {
			result.next();
			int hubId = result.getInt("DeskHubId");
			int floorId = result.getInt("LibraryFloorId");
			int coordinateX = result.getInt("CoordinateX");
			int coordinateY = result.getInt("CoordinateY");
			int lengthX = result.getInt("LengthX");
			int lengthY = result.getInt("LengthY");
			DeskHub dh = new DeskHub(hubId, floorId, coordinateX, coordinateY, lengthX, lengthY);
			return Response.ok()
					.entity(dh)
					.header("Access-Control-Allow-Origin", "*")
					.header("Acess-Control-Allow-Methods", "GET, POST, DELETE, PUT")
					.allow("OPTIONS")
					.build();
		} catch (SQLException e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}
