package com.myamoto.exceltoobject4j.dao.filereader;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.myamoto.exceltoobject4j.dao.ExToObj4jException;
import com.myamoto.exceltoobject4j.dao.TableContent;

public class ExcelFileReader implements ITableFileReader {

	private static final String XLS_Format = "xls";
	
	public List<String> getManagedFormatList() {
		return Arrays.asList(new String[]{XLS_Format});
	}

	@Override
	public TableContent readFile(String filePath)
			throws ExToObj4jException {
		// TODO Auto-generated method stub
		return null;
	}

}
