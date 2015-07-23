package com.fydp.webservices.seatspotter.database.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Floor {
	
	private int floorId;
	private String floorLevel;
	private int totalDesks;
	private int emptyDesks;
	private int unknownState;
	
	public Floor(){}
	
	public Floor(int floorId, String floorLevel, int totalDesks, int emptyDesks, int unknownState){
		this.floorId=floorId;
		this.floorLevel=floorLevel;
		this.totalDesks=totalDesks;
		this.emptyDesks=emptyDesks;
		this.unknownState=unknownState;
	}

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}

	public String getFloorLevel() {
		return floorLevel;
	}

	public void setFloorLevel(String floorLevel) {
		this.floorLevel = floorLevel;
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

	@Override
	public String toString() {
		return "Floor [floorId=" + floorId + ", floorLevel=" + floorLevel
				+ ", totalDesks=" + totalDesks + ", emptyDesks=" + emptyDesks
				+ ", unknownState=" + unknownState + "]";
	}

}
