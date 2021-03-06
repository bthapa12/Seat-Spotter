package com.fydp.webservices.seatspotter.database.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Floor {
	
	private int floorId;
	private int libraryId;
	private String floorLevel;
	
	public Floor(){}
	
	public Floor(int floorId, int libraryId, String floorLevel){
		this.floorId = floorId;
		this.libraryId = libraryId;
		this.floorLevel = floorLevel;
	}

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	public int getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}

	public String getFloorLevel() {
		return floorLevel;
	}

	public void setFloorLevel(String floorLevel) {
		this.floorLevel = floorLevel;
	}

	@Override
	public String toString() {
		return "Floor [floorId=" + floorId + ", libraryId=" + libraryId
				+ ", floorLevel=" + floorLevel + "]";
	}

}
