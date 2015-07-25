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

import com.fydp.webservices.seatspotter.database.DBConstants;
import com.fydp.webservices.seatspotter.database.DBManager;
import com.fydp.webservices.seatspotter.database.model.Desk;

@Path("/libraries/{libraryId}/floors/{floorId}/deskhubs/{deskHubId}/desks")
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
				
				desks.add(new Desk(deskId, deskHubId, deskState));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return desks;
	}
	
	@Path("/staticdesks")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Desk> getStaticFloors(){
		
		List<Desk> desks = new ArrayList<Desk>();
		desks.add(new Desk(1,1,0));
		desks.add(new Desk(2,1,1));
		desks.add(new Desk(3,1,2));
		desks.add(new Desk(4,1,2));
		desks.add(new Desk(5,1,2));
		desks.add(new Desk(6,1,0));
		return desks;
		
	}
	
}
