package com.myamoto.exceltoobject4j.dao.filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.myamoto.exceltoobject4j.dao.ExToObj4jDAOException;
import com.myamoto.exceltoobject4j.dao.GenericTableContent;

public class CSVFileReader implements ITableFileReader {

	private final static String CSV_FILEFORMAT= "csv";

	private final static String CARACTERE_ESPACEMENT = ";";

	/**
	 * Code à revoir
	 * 
	 * @throws IOException 
	 * @throws ExToObj4jDAOException 
	 */
	public GenericTableContent readFile(String filePath) throws ExToObj4jDAOException {

		GenericTableContent result = new GenericTableContent();

		if(filePath != null){
			File file = new File(filePath);
			if(file!=null && file.exists() && file.canRead()) {
				FileInputStream fIs = null;
				InputStreamReader reader = null;
				BufferedReader br = null;
				try {
					fIs = new FileInputStream(file);
					reader = new InputStreamReader(fIs);
					br = new BufferedReader(reader);

					String lineFile;
					while((lineFile = br.readLine()) != null) {
						if(lineFile.startsWith(CARACTERE_ESPACEMENT)) lineFile = "NULL"+lineFile;
						while(lineFile.indexOf(CARACTERE_ESPACEMENT+CARACTERE_ESPACEMENT)!=-1) {
							lineFile = lineFile.replaceAll(CARACTERE_ESPACEMENT+CARACTERE_ESPACEMENT, CARACTERE_ESPACEMENT+"NULL"+CARACTERE_ESPACEMENT);
							if(lineFile.endsWith(CARACTERE_ESPACEMENT))
								lineFile += "NULL";
						}
						String[] infosLine = lineFile.split(CARACTERE_ESPACEMENT);

						List<String> infosLineWithNull = new ArrayList<String>();
						for (String s : infosLine) {
							if(s.equals("NULL")) s=null;
							infosLineWithNull.add(s);
						}
						result.add(Arrays.asList(infosLineWithNull.toArray(new String[infosLineWithNull.size()])));
					}
				} catch (FileNotFoundException e) {
					throw new ExToObj4jDAOException(e.getMessage(), e);
				} catch (IOException e) {
					throw new ExToObj4jDAOException(e.getMessage(), e);
				}
				finally {
					if(br!=null){
						try {
							br.close();
						} catch (IOException e) {
							throw new ExToObj4jDAOException(e.getMessage(), e);
						}
					}
					if(reader!=null){
						try {
							reader.close();
						} catch (IOException e) {
							throw new ExToObj4jDAOException(e.getMessage(), e);
						}
					}
					if(fIs!=null){
						try {
							fIs.close();
						} catch (IOException e) {
							throw new ExToObj4jDAOException(e.getMessage(), e);
						}
					}
				}
			}else{
				throw new ExToObj4jDAOException("cant resolve file : "+file.getAbsolutePath());
			}
		}
		return result;
	}

	public List<String> getManagedFormatList() {
		return Arrays.asList(new String[]{CSV_FILEFORMAT});
	}


}
