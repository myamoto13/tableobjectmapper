package com.myamoto.exceltoobject4j.dao.filereader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.myamoto.exceltoobject4j.dao.ExToObj4jException;
import com.myamoto.exceltoobject4j.dao.TableContent;

public class TableFileReader {

	@Resource(name="fileReaderFactory")
	private FileReaderFactory fileReaderFactory;

	public FileReaderFactory getFileReaderFactory() {
		return fileReaderFactory;
	}

	public void setFileReaderFactory(FileReaderFactory fileReaderFactory) {
		this.fileReaderFactory = fileReaderFactory;
	}

	public TableContent readFile(String tableFilePath) throws ExToObj4jException {
		TableContent result = null;

		File file = new File(tableFilePath);
		if(!file.exists() || !file.canRead()){
			throw new ExToObj4jException("file " + tableFilePath + " can't be read.");
		}
		String extension = "";

		if(tableFilePath != null){
			int i = tableFilePath.lastIndexOf('.');
			if (i > 0) {
				extension = tableFilePath.substring(i+1);
			}
		}

		ITableFileReader fileReader = fileReaderFactory.getFileReader(extension);
		result = fileReader.readFile(tableFilePath);
		
		validate(result);
		
		return result;
	}

	/**
     * Validation de base du format du fichier :<br>
	 * -pas de doublon d'intitulé de colonne ;<br>
	 * -même taille pour toutes les lignes
	 * 
	 * @param tableContent
	 * @throws Exception
	 */
	private void validate(TableContent tableContent) throws ExToObj4jException {
		if(tableContent == null){
			List<String> titleList = tableContent.getTitleList();
			if(titleList == null || titleList.size() == 0){
				throw new ExToObj4jException("no columns.");
			}

			List<List<String>> content = tableContent.getContent();
			
			String logLignesSizeIncorrecte = null;
			for (int i = 0; i < content.size(); ++i) {
				List<String> ligne = content.get(i);
				if(ligne.size() != titleList.size()){
					if(logLignesSizeIncorrecte == null){
						logLignesSizeIncorrecte = "";
					}
					logLignesSizeIncorrecte += "ligne "+i+": "+ligne.size()+", ";
				}
			}
			if(logLignesSizeIncorrecte != null){
				throw new ExToObj4jException("Taille des lignes incorrectes ("+logLignesSizeIncorrecte+")");
			}
			checkDoublons(titleList);
		}
	}
	
	private void checkDoublons(List<String> titleList) throws ExToObj4jException {
		if(titleList != null){
			Map<String, List<Integer>> indicesMemeValeur = new HashMap<String, List<Integer>>();
			for (int i = 0; i < titleList.size(); i++) {
				for (int j = i+1; j < titleList.size(); j++) {
					String title1 = titleList.get(i);
					String title2 = titleList.get(j);
					
					if(title1 != null && title2 != null && title1.equals(title2)){
						List<Integer> indices = indicesMemeValeur.get(title1);
						if(indices == null){
							indices = new ArrayList<Integer>();
							indicesMemeValeur.put(title1, indices);
						}
						if(!indices.contains(i))indices.add(i);
						if(!indices.contains(j))indices.add(j);
					}
				}
			}
			if(indicesMemeValeur.size() > 0){
				String logDoublons = "";
				for(String valeur : indicesMemeValeur.keySet()){
					List<Integer> indices = indicesMemeValeur.get(valeur);
					if(indices != null && indices.size() > 0){
						logDoublons += "\n\""+valeur+"\" : colonnes ";
						for (int i = 0; i < indices.size(); ++i) {
							logDoublons += indices.get(i);
							if(i < indices.size()-1){
								logDoublons += ", ";
							}
						}
					}
				}
				throw new ExToObj4jException("found duplicate column names : " + logDoublons);
			}	
		}
	}

}
