package Application;

import logger.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		LogLevels level = LogLevels.ERROR;
		String file, func, logfile;
		Scanner sc = new Scanner(System.in);
		 
        // String input
		System.out.println("Logger class trial");
        file = sc.nextLine();
        func = sc.nextLine();
        logfile = sc.nextLine();
        //mode = sc.nextLine();
 
		Logger log = new Logger(level, file, func, logfile);
		log.error("ERROR LOG: ERROR ENCOUNTERED during program execution");
		log.info("Logs info");
		log.debug("Default mode");
		
		sc.close();
	}

}
