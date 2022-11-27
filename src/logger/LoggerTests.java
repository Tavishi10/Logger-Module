package logger;

import static org.junit.Assert.*;

import java.util.Date;
import java.io.*;
import org.junit.Test;


//Test cases for the Logger Class
public class LoggerTests {
	//initialize object for class logger
	Logger logger = new Logger(LogLevels.ERROR, "LoggerTests", "logfunc", "LogTest");
	
	
	//test for void info(String) method of Logger class
	@Test
	public void infoTest() throws IOException  {
		
		logger.info("Info message log");
		Date d1 = new Date();
		String expected_output = String.format("%s      %s      %s      %s      %s", d1, "INFO", "LoggerTests", "logfunc", "Info message log");
		
		String actual_output = new String();;
		File file = new File("LogTest.1.txt");
		InputStreamReader streamReader;
		
		try {
			streamReader = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(streamReader);
			while (br.ready()) {
				actual_output = br.readLine();
			}	
			br.close();

		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		assertEquals(expected_output, actual_output);
		
	}
	
	//test for void debug(String) method of Logger class
	@Test
	public void debugTest() throws IOException{
		logger.debug("Debug message log");
		Date d1 = new Date();
		String expected_output = String.format("%s      %s      %s      %s      %s", d1, "DEBUG", "LoggerTests", "logfunc", "Debug message log");
		
		String actual_output = new String();;
		File file = new File("LogTest.1.txt");
		InputStreamReader streamReader;
		
		try {
			streamReader = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(streamReader);
			while (br.ready()) {
				actual_output = br.readLine();
			}	
			br.close();

		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		assertEquals(expected_output, actual_output);
	}
	
	
	//test for void error(String) method of Logger class
	@Test
	public void errorTest() throws IOException{
		logger.error("Error message log");
		Date d1 = new Date();
		String expected_output = String.format("%s      %s      %s      %s      %s", d1, "ERROR", "LoggerTests", "logfunc", "Error message log");
		
		String actual_output = new String();;
		File file = new File("LogTest.1.txt");
		InputStreamReader streamReader;
		
		try {
			streamReader = new InputStreamReader(new FileInputStream(file));
			BufferedReader br = new BufferedReader(streamReader);
			while (br.ready()) {
				actual_output = br.readLine();
			}	
			br.close();

		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		assertEquals(expected_output, actual_output);
	}

}
