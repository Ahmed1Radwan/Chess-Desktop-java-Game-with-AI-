package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import utils.Constants.LogLevel;


public class Log {

	private String fileName = "ChessLog.txt";
	private LogLevel logLevel;
	
	public Log(){
		logLevel = Constants.getLogLevel();
	}
	public void info(String msg) {
		if (logLevel == LogLevel.INFO || logLevel == LogLevel.DEBUG) {
			write("[INFO] "+msg);
		}
	}

	public void debug(String msg) {
		if (logLevel == LogLevel.DEBUG) {
			write("[DEBUG] "+msg);
		}
	}

	public void error(String msg) {
		if (logLevel == LogLevel.DEBUG || logLevel == LogLevel.ERROR || logLevel == LogLevel.INFO) {
			write("[ERROR] "+msg);
		}
	}

	public void write(String msg) {
		String output = "\n" + Utils.getTime() + " " + msg;
		
		Utils.writeToFile(fileName,output);

		}
	

	public void writeLine() {
		write(" -----------------------------------------------");

	}

}
