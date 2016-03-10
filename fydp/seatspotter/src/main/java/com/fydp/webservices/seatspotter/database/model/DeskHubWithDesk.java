package com.fydp.webservices.seatspotter.database.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeskHubWithDesk {
	private int deskHubId;
	private int libraryFloorId;
	private int coordinateX;
	private int coordinateY;
	private int totalDesks;
	private int emptyDesks;
	private int unknownState;
	
	public DeskHubWithDesk(){}
	
	public DeskHubWithDesk(int deskHubId, int libraryFloorId, int coordinateX, int coordinateY, int totalDesks,
			int emptyDesks, int unknownState) {
		this.deskHubId = deskHubId;
		this.libraryFloorId = libraryFloorId;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.totalDesks = totalDesks;
		this.emptyDesks = emptyDesks;
		this.unknownState = unknownState;
	}

	public int getDeskHubId() {
		return deskHubId;
	}

	public void setDeskHubId(int deskHubId) {
		this.deskHubId = deskHubId;
	}

	public int getTotalDesks() {
		return totalDesks;
	}

	public void setTotalDesks(int totalDesks) {
		this.totalDesks = totalDesks;
	}

	public int getEmptyDesks() {
		return emptyDesks;
	}

	public void setEmptyDesks(int emptyDesks) {
		this.emptyDesks = emptyDesks;
	}

	public int getUnknownState() {
		return unknownState;
	}

	public void setUnknownState(int unknownState) {
		this.unknownState = unknownState;
	}

	public int getLibraryFloorId() {
		return libraryFloorId;
	}

	public void setLibraryFloorId(int libraryFloorId) {
		this.libraryFloorId = libraryFloorId;
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
		return "DeskHubWithDesk [deskHubId=" + deskHubId + ", libraryFloorId="
				+ libraryFloorId + ", coordinateX=" + coordinateX
				+ ", coordinateY=" + coordinateY + ", totalDesks=" + totalDesks
				+ ", emptyDesks=" + emptyDesks + ", unknownState="
				+ unknownState + "]";
	}
	
	
	
}
