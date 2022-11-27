package logger;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;

public class FileCreationTests {
	
	FileCreation file = new FileCreation();
	
	@Test
	public void getCurrentFileTest() {
	    File filereturned = file.getCurrFile("LogTest", "Log test message");
	    
	    assertNotNull(filereturned);
	}
	
	//not more than 10 files should be present after rotation and the existing files should be less than or equal to 5MB
	@Test
	public void rotateTest() {
		file.rotateFiles("LogTest"); 
		
		int filecount = 0, idealfilesize = 0;
		File logFile;
		for(int i = 1; i <= 10; i++)
		{
			logFile = new File( "LogTest." + i + ".txt");
			if(logFile.exists())
			{
				filecount++;
				
				if(logFile.length() <= (1*1024))
					idealfilesize++;
			}
		}
		
		assertTrue("No of files <= 10", filecount <= 10);
		assertTrue("All files are less than 5MB", idealfilesize == filecount);
	}
	
}
