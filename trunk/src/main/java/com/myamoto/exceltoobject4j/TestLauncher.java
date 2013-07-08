package com.myamoto.exceltoobject4j;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myamoto.exceltoobject4j.service.TableObjectMapper;


public class TestLauncher {
	
	@Resource(name = "tableObjectMapper")
	private TableObjectMapper tableObjectMapper;
	
	public TableObjectMapper getTableObjectMapper() {
		return tableObjectMapper;
	}

	public void setTableObjectMapper(TableObjectMapper tableObjectMapper) {
		this.tableObjectMapper = tableObjectMapper;
	}

	private void launch(){
		String tableFilePath = "example_data.csv";
		String configurationFilePath = "example_config.xml";
		
		List objectList = tableObjectMapper.importObjects(tableFilePath, configurationFilePath);
	}
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
		TestLauncher launcher = context.getBean("testLauncher", TestLauncher.class);
		launcher.launch();
	}
}
