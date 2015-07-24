package com.fydp.webservices.seatspotter.services;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fydp.webservices.seatspotter.database.DBConstants;
import com.fydp.webservices.seatspotter.database.DBManager;
import com.fydp.webservices.seatspotter.database.model.DeskHub;

@Path("/libraries/{libraryId}/floors/{floorId}/deskhubs")
public class RestApiDeskHubs {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<DeskHub> getDeskHubs(@PathParam("floorId") int floorId){
		ResultSet result;
		List<DeskHub> deskHubs = new ArrayList<DeskHub>();
		
		// setup params for stored procedure
		List<Integer> params = new ArrayList<Integer>();
		params.add(floorId);
		
		result = DBManager.executeProcedureWithParam(DBConstants.GET_DESKHUBS, params);
		
		try{
			while (result.next()){
				int deskHubId = result.getInt("DeskHubId");
				String deskHubLabel = result.getString("DeskHubLabel");
				int totalDesks = result.getInt("TotalDesks");
				int emptyDesks = result.getInt("EmptyDesks");
				int unknownState = result.getInt("UnknownState");
				
				deskHubs.add(new DeskHub(deskHubId,deskHubLabel,totalDesks,emptyDesks,unknownState));
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return deskHubs;
	}

}
