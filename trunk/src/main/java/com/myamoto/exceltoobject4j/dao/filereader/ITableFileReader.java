package com.myamoto.exceltoobject4j.dao.filereader;

import java.util.List;

import com.myamoto.exceltoobject4j.dao.ExToObj4jDAOException;
import com.myamoto.exceltoobject4j.dao.GenericTableContent;

public interface ITableFileReader {

	GenericTableContent readFile(String filePath) throws ExToObj4jDAOException;
	
	List<String> getManagedFormatList();
}
