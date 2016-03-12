package com.fydp.webservices.seatspotter.database.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Desk {
	
	private int deskId;
	private int deskHubId;
	private int deskState;
	private int coordinateX;
	private int coordinateY;
	private int lengthX;
	private int lengthY;
	
	public Desk(){}
	
	public Desk(int deskId, int deskHubId, int deskState, 
			int coordinateX, int coordinateY, int lengthX, int lengthY) {
		this.deskId = deskId;
		this.deskHubId = deskHubId;
		this.deskState = deskState;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.lengthX = lengthX;
		this.lengthY = lengthY;
	}
	
	public int getDeskId() {
		return deskId;
	}
	
	public void setDeskId(int deskId) {
		this.deskId = deskId;
	}
	
	public int getDeskHubId(){
		return deskHubId;
	}
	
	public void setDeskHubId(int deskHubId){
		this.deskHubId = deskHubId;
	}
	
	public int getDeskState() {
		return deskState;
	}
	
	public void setDeskState(int deskState) {
		this.deskState = deskState;
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
		return "Desk [deskId=" + deskId + ", deskHubId=" + deskHubId
				+ ", deskState=" + deskState + ", coordinateX=" + coordinateX
				+ ", coordinateY=" + coordinateY + ", lengthX=" + lengthX
				+ ", lengthY=" + lengthY + "]";
	}
}
