package com.ygo.ygo_parking_project;

import java.util.ArrayList;


public class ParkingZone 
{
	private int idZone;
	private String address;
	private int numberOfParkingSpace;
	private int availableParkingSpace;
	private ArrayList<ParkingSpace> parkingSpace;
	
	public ParkingZone(int idZone, String address, int numberOfParkingSpace, int availableParkingSpace) 
	{
		this.idZone = idZone;
		this.address = address;
		this.numberOfParkingSpace = numberOfParkingSpace;
		this.availableParkingSpace = availableParkingSpace;
		this.parkingSpace = new ArrayList<ParkingSpace>();
	}
	
	public int getIdZone() 
	{
		return idZone;
	}

	public void setIdZone(int idZone) 
	{
		this.idZone = idZone;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public int getNumberOfParkingSpace() 
	{
		return numberOfParkingSpace;
	}

	public void setNumberOfParkingSpace(int numberOfParkingSpace) 
	{
		this.numberOfParkingSpace = numberOfParkingSpace;
	}

	public int getAvailableParkingSpace() 
	{
		return availableParkingSpace;
	}

	public void setAvailableParkingSpace(int availableParkingSpace) 
	{
		this.availableParkingSpace = availableParkingSpace;
	}

	public ArrayList<ParkingSpace> getParkingSpace() {
		if(parkingSpace == null){
			parkingSpace = new ArrayList<ParkingSpace>();
		}
		return parkingSpace;
	}

	public void addParkingSpace(ParkingSpace parking) {
		this.parkingSpace.add(parking);
	}
	
	public void removeParkingSpace(ParkingSpace parking) {
		this.parkingSpace.remove(parking);
	}
	
	public void addParkingSpace(int parkingIndex) {
		this.parkingSpace.remove(parkingIndex);
	}

}
