package com.ygo.ygo_parking_project;

import java.io.Serializable;


public class Favorites implements Serializable
{
	private String title;
	private String addrees;
	
	public Favorites(String parkingZone, String title)
	{
		this.addrees=parkingZone;
		this.title = title;
	}

	public String getAddrees() {
		return addrees;
	}

	public void setAddrees(String addrees) {
		this.addrees = addrees;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString(){
		return getTitle() + " - " + getAddrees();
	}
}
