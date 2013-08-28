package com.myamoto.exceltoobject4j.dao.reader;

import java.util.List;

import com.myamoto.exceltoobject4j.ExToObj4jException;
import com.myamoto.exceltoobject4j.dao.TableContent;

public interface ITableFileReader {

	TableContent readFile(String filePath) throws ExToObj4jException;
	
	List<String> getManagedFormatList();
}
