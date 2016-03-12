package com.fydp.webservices.seatspotter.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fydp.webservices.seatspotter.database.DBConstants;
import com.fydp.webservices.seatspotter.database.DBManager;
import com.fydp.webservices.seatspotter.database.model.Library;
import com.fydp.webservices.seatspotter.database.model.LibraryWithDesk;

@Path("/libraries")
public class RestApiLibraries {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//public List<LibraryWithDesk> getLibrariesWithDesks(){
	public Response getLibrariesWithDesks(){
		
		ResultSet result;
		List<LibraryWithDesk> libraries = new ArrayList<LibraryWithDesk>();
		
		result = DBManager.selectProcedureWithNoParam(DBConstants.GET_LIBRARIES);
		
		try {
			while(result.next()){
				int libraryId = result.getInt("LibraryId");
				String libraryName = result.getString("LibraryName");
				int totalDesks = result.getInt("TotalDesks");
				int emptyDesks = result.getInt("EmptyDesks");
				int unknownState = result.getInt("UnknownState");
				
				libraries.add(new LibraryWithDesk(libraryId, libraryName, totalDesks, emptyDesks, unknownState));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// return libraries;
		GenericEntity<List<LibraryWithDesk>> entity = new GenericEntity<List<LibraryWithDesk>>(libraries){};
		return Response.ok()
				.entity(entity)
				.header("Access-Control-Allow-Origin", "*")
				.header("Acess-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS")
				.build();
		
	}
	
	@GET
	@Path("/{libraryId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLibrary(@PathParam("libraryId") int libraryId){
		
		ResultSet result;
		List<Integer> params = new ArrayList<Integer>();
		params.add(libraryId);
		
		result = DBManager.selectProcedureWithParam(DBConstants.GET_LIBRARYBYID, params);
		try {
				result.next();
				int libId = result.getInt("LibraryId");
				String libraryName = result.getString("LibraryName");
				Library lib = new Library(libId, libraryName);
				return Response.ok()
						.entity(lib)
						.header("Access-Control-Allow-Origin", "*")
						.header("Acess-Control-Allow-Methods", "GET, POST, DELETE, PUT")
						.allow("OPTIONS")
						.build();
		} catch (SQLException e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	//TODO: Need to fix this
	public Response insertLibrary(Library lib){
		
		ResultSet result;
		String libraryName = lib.getLibraryName();
		
		result = DBManager.insertLibrary(DBConstants.INSERT_LIBRARY, libraryName);
		try {
			//String url = 
			result.next();
			int libId = result.getInt("LibraryId");
			String libName = result.getString("LibraryName");
			Library createdlib = new Library(libId, libName);
			//TODO: change it to created response
			return Response.ok()
					.entity(createdlib)
					.header("Access-Control-Allow-Origin", "*")
					.header("Acess-Control-Allow-Methods", "GET, POST, DELETE, PUT")
					.allow("OPTIONS")
					.build();
		} catch (SQLException e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	//TODO: Need to fix this
	public Response upldateLibrary(Library lib){
		
		ResultSet result;
		int libraryId = lib.getLibraryId();
		String libraryName = lib.getLibraryName();
		
		result = DBManager.updateLibrary(DBConstants.UPDATE_LIBRARY, libraryId, libraryName);
		if (result != null){
			return Response.ok().build();
		} else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DELETE
	@Path("/{libraryId}")
	public Response deleteLibrary(@PathParam("libraryId") int libraryId) {
		
		
		return null;
	}
	
}
