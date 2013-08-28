package com.myamoto.exceltoobject4j.dao.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TableFileWriter {

	public void writeCSVFile(File outputFile, List<String[]> lignes, String caractereEspacement) throws IOException {
		if(caractereEspacement != null && lignes != null && outputFile != null){
			PrintWriter printWriter =  new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
			for (String[] ligne : lignes) {
				if(ligne != null && ligne.length > 0){
					for (int i = 0; i < ligne.length; ++i ) {
						String celulle = ligne[i];
						printWriter.print(celulle != null?celulle:"");
						if(i < ligne.length - 1){
							printWriter.print(caractereEspacement);
						}
					}
					printWriter.println();
				}
				
			}
			printWriter.close();
		}
	}
}
