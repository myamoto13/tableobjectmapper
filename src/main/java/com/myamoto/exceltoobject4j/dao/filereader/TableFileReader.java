package com.myamoto.exceltoobject4j.dao.filereader;

import java.io.File;

import javax.annotation.Resource;

import com.myamoto.exceltoobject4j.dao.ExToObj4jDAOException;
import com.myamoto.exceltoobject4j.dao.GenericTableContent;

public class TableFileReader {

	@Resource(name="fileReaderFactory")
	private FileReaderFactory fileReaderFactory;

	public FileReaderFactory getFileReaderFactory() {
		return fileReaderFactory;
	}

	public void setFileReaderFactory(FileReaderFactory fileReaderFactory) {
		this.fileReaderFactory = fileReaderFactory;
	}

	public GenericTableContent readFile(String tableFilePath) throws ExToObj4jDAOException {
		GenericTableContent result = null;

		File file = new File(tableFilePath);

		if(file.exists() && file.canRead()){
			String extension = "";

			if(tableFilePath != null){
				int i = tableFilePath.lastIndexOf('.');
				if (i > 0) {
					extension = tableFilePath.substring(i+1);
				}
			}

			ITableFileReader fileReader = fileReaderFactory.getFileReader(extension);
			result = fileReader.readFile(tableFilePath);
		}
		return result;
	}


}
