package logger;

import java.io.File;

public class FileCreation {
	//private long maxSize = 5*1024*1024;
	private long maxSize = 1*1024;
	private int maxFiles = 10;
	
	public long maxSize() {
		return maxSize;
	}
	
	public int maxNoOfFiles() {
		return maxFiles;
	}
	
	//function which returns file object in which the log will be appended
	public File getCurrFile(String filename, String message) {
		//Object which points to the first file 'file.1.txt'
		File file = new File(filename + "." + 1 + ".txt");
		
		//if the file exists
		if(file.exists()) {
			
			//check if the size of the file.1 and new log together is > maxSize
			if((file.length() + message.getBytes().length) > maxSize())
			{
				//the size is greater so rotate the files
				file = rotateFiles(filename);
			}
		}
		else {
			//File.1 doesn't exist => create new file
			file = createFile(file);
		}
		
		return file;
	}
	
	
	//function to rotate the log files
	public File rotateFiles(String filename) {

		int fileno = 10;
		File target;
		File file = new File("");
		
		//loop till file no is greater than equal to 1 
		while(fileno >= 1 ) {
		
			//Initialize with the format File.fileno eg File.10.txt .... to File.1.txt
			file = new File(filename + "." + fileno + ".txt");
			
			
			if(fileno == 10 && file.exists()) {
				//delete the 10th file
				file.delete();
			}
			
			else if(file.exists()){
				//if the other files exist
				
				//Initialize with the new name to be assigned ie. fileno+1 to rotate
				target = new File(filename + "." + (fileno + 1) + ".txt");
				
				//rename the file
				file.renameTo(target);
				
				
				if(fileno == 1)
				{
					//if the fileno is 1 create a new file because there will be no existing file with .1 suffix as all the files have been renamed
					file = createFile(file);
				}
			}
			fileno--; //decrement fileno
		}
		return file;
		
	}	
	
	
	//function which creates a new file
	public File createFile(File file) {
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
		return file;
	}
}
