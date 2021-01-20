package demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {
 
	public String ReadData(String param) throws FileNotFoundException, IOException, ParseException {
		
		JSONParser jsonparse=new JSONParser();
		
		JSONObject jsonobj=(JSONObject)jsonparse.parse(new FileReader("jsonData\\Credentials.json"));
	
		String value = (String)jsonobj.get(param);
	
		return value;
	}
}
