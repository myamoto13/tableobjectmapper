//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.6 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2013.09.02 � 11:24:01 PM CEST 
//


package com.myamoto.exceltoobject4j.tableobjectmapping;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.myamoto.exceltoobject4j.tableobjectmapping package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TableObjectMapping_QNAME = new QName("http://www.exceltoobject4j.myamoto.com/tableObjectMapping", "tableObjectMapping");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.myamoto.exceltoobject4j.tableobjectmapping
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TableObjectMapping }
     * 
     */
    public TableObjectMapping createTableObjectMapping() {
        return new TableObjectMapping();
    }

    /**
     * Create an instance of {@link TypeMapper }
     * 
     */
    public TypeMapper createTypeMapper() {
        return new TypeMapper();
    }

    /**
     * Create an instance of {@link FieldMapper }
     * 
     */
    public FieldMapper createFieldMapper() {
        return new FieldMapper();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TableObjectMapping }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.exceltoobject4j.myamoto.com/tableObjectMapping", name = "tableObjectMapping")
    public JAXBElement<TableObjectMapping> createTableObjectMapping(TableObjectMapping value) {
        return new JAXBElement<TableObjectMapping>(_TableObjectMapping_QNAME, TableObjectMapping.class, null, value);
    }

}
