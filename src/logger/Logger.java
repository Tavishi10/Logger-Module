package logger;

import java.util.*;
import java.io.File;
import java.io.FileWriter;

public class Logger {
	private LogLevels logLevel;
	private String sourceFile;
	private String funcName;
	private String targetFile;
	private File file;
	private String fileMode;
		
	//constructor to instantiate object of Logger class
	public Logger(LogLevels level, String file, String func, String logfile) {
		logLevel = level;
		sourceFile = file;
		funcName = func;
		targetFile = logfile;
		fileMode = "append";
	}
		
	//function to append the log in the file
	private void append_message(String message, LogLevels log) {
		
		//if the log level is smaller or equal to 
		if(logLevel.compareTo(log) >= 0) {
			
			//initialize object of FileCreation class
		    FileCreation fileCreate = new FileCreation();
		    file = fileCreate.getCurrFile(targetFile, message);
			
		    //generate the complete log message
		    Date d1 = new Date();
		    String data = String.format("%s      %s      %s      %s      %s\n", d1, log, sourceFile, funcName, message);
		    
		    //write the message in the log file
		    try {
	            // create a FileWriter in the given mode
		    	FileWriter output;
		 
		    	if(fileMode.toLowerCase().equals("append"))
		    	{
		    		//append mode
		    		output  = new FileWriter(file, true);
		    	}
		    	else
		    	{
		    		//write mode
		    		output  = new FileWriter(file, false);
		    	}
	  
	            // write the log message to the file
	            output.write(data);
	  
	            // close the writer
	            output.close();
	        }
	  
	        catch (Exception e) {
	            e.getStackTrace();
	        }
		    
		}
		
	}
	
	//function to log info message
	public void info(String message) { 
		append_message(message, LogLevels.INFO);
	}
	
	//function to log debug message
	public void debug(String message) {
		append_message(message, LogLevels.DEBUG);
	}

	//function to log error message
	public void error(String message) {
		append_message(message, LogLevels.ERROR);
	}
}

