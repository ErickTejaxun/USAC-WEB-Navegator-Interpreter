SET JAVA_HOME="C:\Program Files\Java\jdk1.8.0_31\bin" 
SET PATH=%JAVA_HOME%;%PATH% 
SET CLASSPATH=%JAVA_HOME%; 
SET JFLEX_HOME= C:\libs\jflex-1.6.1
cd C:\Users\erick\Documents\NetBeansProjects\USAC-WEB\src\Source\CCSS
java -jar %JFLEX_HOME%\lib\jflex-1.6.1.jar CSSScanner.jflex
pause 
