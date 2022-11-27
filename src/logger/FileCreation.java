package logger;

import java.io.File;

public class FileCreation {
	//private long maxSize = 5*1024*1024;
	private long maxSize = 1*1024;
	private int maxFiles = 1;
	
	public long maxSize() {
		return maxSize;
	}
	
	public int maxNoOfFiles() {
		return maxFiles;
	}
	
	
	public File getCurrFile(String filename, String message) {
		System.out.println("In get Currentfile func");
		File file = new File(filename + "." + 1 + ".txt");
		
		if(file.exists()) {
			System.out.println("If file 1 exists");
			System.out.println(file.length() + message.getBytes().length);
			System.out.println(maxSize());
			if((file.length() + message.getBytes().length) > maxSize())
			{
				System.out.println("File size will be greater so rotate");
				file = rotateFiles(filename);
			}
		}
		else {
			try {
				System.out.println("If file 1 does not exist, create new file 1");
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
		}
		
		return file;
	}
	
	public File rotateFiles(String filename) {
		System.out.println("Inside rotation");
		int fileno = 10;
		File target;
		File file = new File("");
		
		while(fileno >= 1 ) {
			System.out.println(fileno);
			file = new File(filename + "." + fileno + ".txt");
			if(fileno == 10 && file.exists()) {
				//delete the 10th file
				file.delete();
				System.out.println("10th file deleted");
			}
			else if(file.exists() ){
				System.out.println("File "+ fileno + "present");
				target = new File(filename + "." + (fileno + 1) + ".txt");
				file.renameTo(target);
				System.out.println("Renamed to " + (fileno+1));
				
				if(fileno == 1)
				{
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
				}
			}
			fileno--;
		}
		return file;
		
	}	
}
