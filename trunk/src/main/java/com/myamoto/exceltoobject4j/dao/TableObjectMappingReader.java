package com.myamoto.exceltoobject4j.dao;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.myamoto.exceltoobject4j.ExToObj4jException;
import com.myamoto.exceltoobject4j.tableobjectmapping.TableObjectMapping;

public class TableObjectMappingReader {

	private static Logger logger = Logger.getLogger(TableObjectMappingReader.class);


	public TableObjectMapping read(File fileObjectMapping) throws ExToObj4jException {

		logger.debug("Validating " + fileObjectMapping);

		validateXSD(fileObjectMapping);

		logger.debug("unmarshalling " + fileObjectMapping);

		try {

			JAXBContext ctxt = JAXBContext.newInstance("com.myamoto.exceltoobject4j.tableobjectmapping");

			Unmarshaller um = ctxt.createUnmarshaller();

			JAXBElement<TableObjectMapping> root = (JAXBElement<TableObjectMapping>) um.unmarshal(fileObjectMapping);
			return root.getValue();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Validate user's config against XSD.
	 * 
	 * @param objectMappingFilePath
	 * @throws ExToObj4jException
	 */
	private void validateXSD(File fileObjectMapping) throws ExToObj4jException {
		Source xmlFile = new StreamSource(fileObjectMapping);
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		try {
			Schema schema = schemaFactory.newSchema(getClass().getClassLoader().getResource("tableimporterconfig.xsd"));
			Validator validator = schema.newValidator();

			validator.validate(xmlFile);
			
			logger.debug("schema " + fileObjectMapping + " is valid.");
		} catch (SAXException e) {
			String msg = fileObjectMapping.getAbsolutePath() + " not valid : " + e.getMessage() +".";
			msg += "Reason : " + e.getLocalizedMessage();
			throw new ExToObj4jException(msg);
		} catch (IOException e) {
			throw new ExToObj4jException(e);
		} 
	}

}
