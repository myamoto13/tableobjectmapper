package com.myamoto.exceltoobject4j.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.myamoto.exceltoobject4j.ExToObj4jException;
import com.myamoto.exceltoobject4j.dao.TableContent;
import com.myamoto.exceltoobject4j.dao.TableObjectMappingReader;
import com.myamoto.exceltoobject4j.dao.reader.TableFileReader;
import com.myamoto.exceltoobject4j.dao.writer.TableFileWriter;
import com.myamoto.exceltoobject4j.tableobjectmapping.TableObjectMapping;

public class TableObjectMapper {
	
	private static Logger logger = Logger.getLogger(TableObjectMapper.class);
	
	@Resource(name="tableObjectMappingReader")
	private TableObjectMappingReader tableObjectMappingReader;

	@Resource(name="tableFileReader")
	private TableFileReader tableFileReader;

	@Resource(name="tableFileWriter")
	private TableFileWriter tableFileWriter;

	public TableFileReader getTableFileReader() {
		return tableFileReader;
	}

	public void setTableFileReader(TableFileReader tableFileReader) {
		this.tableFileReader = tableFileReader;
	}

	public TableFileWriter getTableFileWriter() {
		return tableFileWriter;
	}

	public void setTableFileWriter(TableFileWriter tableFileWriter) {
		this.tableFileWriter = tableFileWriter;
	}

	public TableObjectMappingReader getTableObjectMappingReader() {
		return tableObjectMappingReader;
	}

	public void setTableObjectMappingReader(
			TableObjectMappingReader tableObjectMappingReader) {
		this.tableObjectMappingReader = tableObjectMappingReader;
	}

	public List<? extends Object> importObjects(String tableFilePath, String objectMappingFilePath) throws ExToObj4jException {
		List<? extends Object> result = null;
		
		logger.debug("importing objects " + tableFilePath + " // " + objectMappingFilePath);
		
		File fileObjectMapping = new File(objectMappingFilePath);
		
		TableObjectMapping tableObjectMapping = tableObjectMappingReader.read(fileObjectMapping);
		
		logger.debug("got mapping file " + tableObjectMapping);
		
		TableContent content = tableFileReader.readFile(tableFilePath);
		
		return result;
	}

}
