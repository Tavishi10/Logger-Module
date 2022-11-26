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
		
	public Logger(LogLevels level, String file, String func, String logfile, String mode) {
		logLevel = level;
		sourceFile = file;
		funcName = func;
		targetFile = logfile;
		fileMode = mode;
	}
		
	public void append_message(String message, LogLevels log) {
		//File object creation and open in given mode
		//check level => logLevel >= log level of object => print in file
		//print in given 
		System.out.println("Compare "+ logLevel.compareTo(log));
		if(logLevel.compareTo(log) >= 0) {
			file = new File(targetFile);

		    try {
		      boolean value = file.createNewFile();
		      if (value) {
		        System.out.println("The new file is created.");
		      }
		      else {
		        System.out.println("The file already exists.");
		      }
		    }
		    catch(Exception e) {
		      e.getStackTrace();
		    }
		    
		    //generate the complete log message
		    Date d1 = new Date();
		    String data = String.format("%s      %s      %s      %s      %s\n", d1, log, sourceFile, funcName, message);
		    
		    //write the message in the log file
		    try {
	            // create a FileWriter in the given mode
		    	System.out.println("In Writer code");
		    	FileWriter output;
		    	System.out.println(fileMode);
		    	System.out.println(fileMode.toLowerCase().equals("append"));
		    	if(fileMode.toLowerCase().equals("append"))
		    	{
		    		output  = new FileWriter(file, true);
		    		System.out.println("Append mode");
		    	}
		    	else
		    	{
		    		output  = new FileWriter(file, false);
		    		System.out.println("Write mode");
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
	
	
	public void info(String message) {
		append_message(message, LogLevels.INFO);
	}
	
	public void debug(String message) {
		append_message(message, LogLevels.DEBUG);
	}

	public void error(String message) {
		append_message(message, LogLevels.ERROR);
	}
}

