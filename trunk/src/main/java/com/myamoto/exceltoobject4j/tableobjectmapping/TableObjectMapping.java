//
// Ce fichier a �t� g�n�r� par l'impl�mentation de r�f�rence JavaTM Architecture for XML Binding (JAXB), v2.2.6 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apport�e � ce fichier sera perdue lors de la recompilation du sch�ma source. 
// G�n�r� le : 2013.09.02 � 11:24:01 PM CEST 
//


package com.myamoto.exceltoobject4j.tableobjectmapping;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour tableObjectMapping complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="tableObjectMapping">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="typeMapper" type="{http://www.exceltoobject4j.myamoto.com/tableObjectMapping}typeMapper" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tableObjectMapping", propOrder = {
    "typeMapper"
})
public class TableObjectMapping {

    protected List<TypeMapper> typeMapper;

    /**
     * Gets the value of the typeMapper property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the typeMapper property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTypeMapper().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TypeMapper }
     * 
     * 
     */
    public List<TypeMapper> getTypeMapper() {
        if (typeMapper == null) {
            typeMapper = new ArrayList<TypeMapper>();
        }
        return this.typeMapper;
    }

}
