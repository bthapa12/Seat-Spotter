package com.fydp.webservices.seatspotter.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fydp.webservices.seatspotter.database.DBConnection;
import com.fydp.webservices.seatspotter.database.DBConstants;
import com.fydp.webservices.seatspotter.database.DBManager;
import com.fydp.webservices.seatspotter.database.model.Library;

@Path("/libraries")
public class RestApiLibraries {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Library> getStoredLibraries(){
		
		ResultSet result;
		List<Library> libraries = new ArrayList<Library>();
		
		result = DBManager.executeProcedureWithNoParam(DBConstants.GET_LIBRARIES);
		
		try {
			while(result.next()){
				int libraryId = result.getInt("LibraryId");
				String libraryName = result.getString("LibraryName");
				int totalDesks = result.getInt("TotalDesks");
				int emptyDesks = result.getInt("EmptyDesks");
				int unknownState = result.getInt("UnknownState");
				
				libraries.add(new Library(libraryId, libraryName, totalDesks, emptyDesks, unknownState));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return libraries;
		
		// return Response.ok().entity(libraries).build();
		
	}
	
}
