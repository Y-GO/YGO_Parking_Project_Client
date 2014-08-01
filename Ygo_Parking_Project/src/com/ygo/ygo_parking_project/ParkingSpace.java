package com.ygo.ygo_parking_project;

public class ParkingSpace {
	private int idSlot;
	private String coordinates;
	private String slotType;
	private boolean available;
	
	public ParkingSpace(int idSlot, String coordinates, String slotType) 
	{
		this.idSlot = idSlot;
		this.coordinates = coordinates;
		this.slotType = slotType;
		this.available = true;
	}
	
	public ParkingSpace(int idSlot, String coordinates, String slotType, boolean available) 
	{
		this.idSlot = idSlot;
		this.coordinates = coordinates;
		this.slotType = slotType;
		this.available = available;
	}
	
	public int getIdSlot() {
		return idSlot;
	}
	public void setIdSlot(int idSlot) {
		this.idSlot = idSlot;
	}
	public String getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	public String getSlotType() {
		return slotType;
	}
	public void setSlotType(String slotType) {
		this.slotType = slotType;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
}
