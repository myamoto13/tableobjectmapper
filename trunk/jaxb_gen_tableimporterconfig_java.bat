SET CLASSPATH=.
SET CLASSPATH=%CLASSPATH%;.\lib\jaxb-api.jar
SET CLASSPATH=%CLASSPATH%;.\lib\jaxb-impl.jar

"C:\Program Files\Java\jdk1.6.0_45\bin\xjc" ./src/main/resources/tableimporterconfig.xsd -d "src/main/java"