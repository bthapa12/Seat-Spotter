package com.fydp.webservices.seatspotter.database.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeskHub {
	
	private int deskHubId;
	private int floorId;
	private int coordinateX;
	private int coordinateY;
	private int lengthX;
	private int lengthY;
	
	public DeskHub(int deskHubId, int floorId, int coordinateX,
			int coordinateY, int lengthX, int lengthY) {
		this.deskHubId = deskHubId;
		this.floorId = floorId;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.lengthX = lengthX;
		this.lengthY = lengthY;
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

	public int getLengthX() {
		return lengthX;
	}

	public void setLengthX(int lengthX) {
		this.lengthX = lengthX;
	}

	public int getLengthY() {
		return lengthY;
	}

	public void setLengthY(int lengthY) {
		this.lengthY = lengthY;
	}

	@Override
	public String toString() {
		return "DeskHub [deskHubId=" + deskHubId + ", floorId=" + floorId
				+ ", coordinateX=" + coordinateX + ", coordinateY="
				+ coordinateY + ", lengthX=" + lengthX + ", lengthY=" + lengthY
				+ "]";
	}
}
