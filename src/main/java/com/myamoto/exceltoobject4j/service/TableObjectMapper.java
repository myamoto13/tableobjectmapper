package com.myamoto.exceltoobject4j.service;

import java.util.List;

import javax.annotation.Resource;

import com.myamoto.exceltoobject4j.dao.ExToObj4jDAOException;
import com.myamoto.exceltoobject4j.dao.GenericTableContent;
import com.myamoto.exceltoobject4j.dao.filereader.TableFileReader;

public class TableObjectMapper {

	@Resource(name="tableFileReader")
	private TableFileReader tableFileReader;

	@Resource(name="tableFileWriter")
	private TableFileReader tableFileWriter;

	public TableFileReader getTableFileReader() {
		return tableFileReader;
	}

	public void setTableFileReader(TableFileReader tableFileReader) {
		this.tableFileReader = tableFileReader;
	}

	public TableFileReader getTableFileWriter() {
		return tableFileWriter;
	}

	public void setTableFileWriter(TableFileReader tableFileWriter) {
		this.tableFileWriter = tableFileWriter;
	}

	public List importObjects(String tableFilePath, String configurationFilePath) throws ExToObj4jDAOException {
		List result = null;
		
		GenericTableContent content = tableFileReader.readFile(tableFilePath);
		
		return result;
	}
	
	
}
