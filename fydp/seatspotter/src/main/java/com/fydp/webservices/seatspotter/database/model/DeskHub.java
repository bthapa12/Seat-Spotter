package com.fydp.webservices.seatspotter.database.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeskHub {
	
	private int deskHubId;
	private int floorId;
	private int coordinateX;
	private int coordinateY;
	
	public DeskHub(int deskHubId, int floorId, int coordinateX,
			int coordinateY) {
		this.deskHubId = deskHubId;
		this.floorId = floorId;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}

	public DeskHub(){}

	public int getDeskHubId() {
		return deskHubId;
	}

	public void setDeskHubId(int deskHubId) {
		this.deskHubId = deskHubId;
	}

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	public int getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}

	public int getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
	}

	@Override
	public String toString() {
		return "DeskHub [deskHubId=" + deskHubId + ", floorId=" + floorId
				+ ", coordinateX=" + coordinateX + ", coordinateY="
				+ coordinateY + "]";
	}
	
	
}
