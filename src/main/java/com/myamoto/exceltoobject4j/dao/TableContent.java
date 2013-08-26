package com.myamoto.exceltoobject4j.dao;

import java.util.ArrayList;
import java.util.List;

public class TableContent {

	private List<List<String>> tableContent;
	private List<String> title;
	
	public TableContent() {
		tableContent = new ArrayList<List<String>>();
	}
	
	public void setTitle(List<String> title) {
		this.title = title;
	}

	public void addLine(List<String> csvLine) {
		if(csvLine != null){
			tableContent.add(csvLine);	
		}
	}

	public List<List<String>> getContent() {
		return (List<List<String>>) ((ArrayList<List<String>>) tableContent).clone();
	}

	public List<String> getTitleList() {
		return title;
	}
	
	
	
}
