package com.fydp.webservices.seatspotter.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fydp.webservices.seatspotter.database.DBConstants;
import com.fydp.webservices.seatspotter.database.DBManager;
import com.fydp.webservices.seatspotter.database.model.Desk;

@Path("/deskhubs/{deskHubId}/desks")
public class RestApiDesks {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Desk> getDesks(@PathParam("deskHubId") int hubId){
		List<Desk> desks = new ArrayList<Desk>();
		ResultSet rs;
		
		List<Integer> params = new ArrayList<Integer>();
		params.add(hubId);
		
		rs=DBManager.executeProcedureWithParam(DBConstants.GET_DESKS, params);
		
		try {
			while (rs.next()){
				int deskId = rs.getInt("DeskId");
				int deskHubId = rs.getInt("DeskHubId");
				int deskState = rs.getInt("DeskState");
				int coordinateX = rs.getInt("CoordinateX");
				int coordinateY = rs.getInt("CoordinateY");
				desks.add(new Desk(deskId, deskHubId, deskState, coordinateX, coordinateY));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return desks;
	}
	
	@GET
	@Path("/{deskId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDesk(@PathParam("deskHubId") int hubId, @PathParam("deskId") int deskId){
		
		ResultSet result;
		List<Integer> params = new ArrayList<Integer>();
		params.add(hubId);
		params.add(deskId);
		
		result=DBManager.executeProcedureWithParam(DBConstants.GET_DESKSBYID, params);
		
		try {
			result.next();
			int dId = result.getInt("DeskId");
			int deskHubId = result.getInt("DeskHubId");
			int deskState = result.getInt("DeskState");
			int coordinateX = result.getInt("CoordinateX");
			int coordinateY = result.getInt("CoordinateY");
			Desk desk = new Desk(dId, deskHubId, deskState, coordinateX, coordinateY);
			return Response.ok().entity(desk).build();
		} catch (SQLException e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
