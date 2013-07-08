package com.myamoto.exceltoobject4j.dao.filereader;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.myamoto.exceltoobject4j.dao.GenericTableContent;

public class ExcelFileReader implements ITableFileReader {

	private static final String XLS_Format = "xls";
	
	public GenericTableContent readFile(File file) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getManagedFormatList() {
		return Arrays.asList(new String[]{XLS_Format});
	}

}
