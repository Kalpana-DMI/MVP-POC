package demo;


public class ConfigFileReader {

	public static String getReportConfigPath(){
	 String reportConfigPath=System.getProperty("user.dir") + "\\src\\main\\java\\utils\\extent-config.xml";
	 return reportConfigPath; 
	}

	
}
