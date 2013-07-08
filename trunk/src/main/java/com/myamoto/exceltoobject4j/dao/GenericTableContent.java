package com.myamoto.exceltoobject4j.dao;

import java.util.ArrayList;
import java.util.List;

public class GenericTableContent {

	private ArrayList<List<String>> tableContent;
	
	public GenericTableContent() {
		tableContent = new ArrayList<List<String>>();
	}
	
	public void add(List<String> csvLine) {
		if(csvLine != null){
			tableContent.add(csvLine);	
		}
	}

	public ArrayList<List<String>> getTableContent() {
		return (ArrayList<List<String>>) tableContent.clone();
	}
	
}
