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
		
	public Logger(LogLevels level, String file, String func, String logfile) {
		logLevel = level;
		sourceFile = file;
		funcName = func;
		targetFile = logfile;
		fileMode = "append";
		
		//create file , String mode
	}
		
	public void append_message(String message, LogLevels log) {
		
		System.out.println("Compare "+ logLevel.compareTo(log));
		if(logLevel.compareTo(log) >= 0) {
			
		    FileCreation f = new FileCreation();
		    file = f.getCurrFile(targetFile, message);
			
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
	
	
	public void info(String message) { //formatted string
		append_message(message, LogLevels.INFO);
	}
	
	public void debug(String message) {
		append_message(message, LogLevels.DEBUG);
	}

	public void error(String message) {
		append_message(message, LogLevels.ERROR);
	}
}

