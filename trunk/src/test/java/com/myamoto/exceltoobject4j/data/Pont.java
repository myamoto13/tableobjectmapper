package com.myamoto.exceltoobject4j.data;

import java.util.List;


public class Pont {
	
	private String name;
	private int id;
	private List<Pile> pileList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Pile> getPileList() {
		return pileList;
	}
	public void setPileList(List<Pile> pileList) {
		this.pileList = pileList;
	}
	
	

}
