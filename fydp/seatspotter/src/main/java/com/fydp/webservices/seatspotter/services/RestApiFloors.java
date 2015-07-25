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
import com.fydp.webservices.seatspotter.database.model.FloorWithDesk;

@Path("libraries/{libraryId}/floors")
public class RestApiFloors {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FloorWithDesk> getFloors(@PathParam("libraryId") int libraryId){
		
		ResultSet result;
		List<FloorWithDesk> floors = new ArrayList<FloorWithDesk>();
		
		// setup params for stored procedure
		List<Integer> params = new ArrayList<Integer>();
		params.add(libraryId);
		
		result = DBManager.executeProcedureWithParam(DBConstants.GET_FLOORS, params);
		
		try{
			while (result.next()){
				int floorId = result.getInt("LibraryFloorId");
				String floorLevel = result.getString("FloorLevel");
				int totalDesks = result.getInt("TotalDesks");
				int emptyDesks = result.getInt("EmptyDesks");
				int unknownState = result.getInt("UnknownState");
				
				floors.add(new FloorWithDesk(floorId,floorLevel,totalDesks,emptyDesks,unknownState));
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return floors;
		
		// return Response.ok().entity(floors).build();
	}
	
	@Path("/staticfloors")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FloorWithDesk> getStaticFloors(){
		
		List<FloorWithDesk> floors = new ArrayList<FloorWithDesk>();
		floors.add(new FloorWithDesk(1,"Bottom Level",1,1,1));
		floors.add(new FloorWithDesk(2,"Main Floor",1,1,1));
		return floors;
		
	}

}
