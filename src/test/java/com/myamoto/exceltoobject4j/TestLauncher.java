package com.myamoto.exceltoobject4j;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myamoto.exceltoobject4j.dao.ExToObj4jException;
import com.myamoto.exceltoobject4j.service.TableObjectMapper;

public class TestLauncher {
	
	@Test
	public void test() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
		TableObjectMapper tableObjectMapper = context.getBean("tableObjectMapper", TableObjectMapper.class);
		
		String tableFilePath = "./src/test/resources/simpledatas.csv";
		String configurationFilePath = "./src/test/resources/tableobjectmapping_example.xml";
		
		try {
			List objectList = tableObjectMapper.importObjects(tableFilePath, configurationFilePath);
		} catch (ExToObj4jException e) {
			Assert.fail(e.getMessage());
		}
		
		context.close();
	}
}
