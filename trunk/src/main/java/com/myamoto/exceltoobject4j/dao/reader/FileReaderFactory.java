package com.myamoto.exceltoobject4j.dao.reader;

import java.util.ArrayList;
import java.util.List;


public class FileReaderFactory {

	private List<ITableFileReader> baseFileReaderList;
	private List<ITableFileReader> customFileReaderList;

	public FileReaderFactory() {
		baseFileReaderList = new ArrayList<ITableFileReader>();

		//TODO : décommenter ces lignes au fur et à mesure que les formats sont disponibles.

		//		baseFileReaderList.add(new ExcelFileReader());
		//		baseFileReaderList.add(new OpenOfficeFileReader());
		baseFileReaderList.add(new CSVFileReader());

		customFileReaderList = new ArrayList<ITableFileReader>();
	}

	public void addCustomFileReader(ITableFileReader customFileReader) {
		customFileReaderList.add(customFileReader);
	}

	/**
	 * Renvoie le premier IFileReader rencontré gérant l'extension demandée 
	 * en cherchant en priorité parmi les fileReader personnalisés.<br>
	 * 
	 * @param extension
	 * @return
	 */
	public ITableFileReader getFileReader(String extension) {
		ITableFileReader result = null;
		for (ITableFileReader tableFileReader : customFileReaderList) {
			if(tableFileReader.getManagedFormatList().contains(extension)){
				result = tableFileReader;
				break;
			}
		}
		if(result == null){
			for (ITableFileReader tableFileReader : baseFileReaderList) {
				if(tableFileReader.getManagedFormatList().contains(extension)){
					result = tableFileReader;
					break;
				}
			}
		}

		return result;
	}

}
