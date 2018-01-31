package com.turner.pga.scoring.data.pga.input.sdmfconfig;

import java.io.IOException;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

public class TournamentProcessor {

	public static Tournament loadXmlFile(String filename) throws JAXBException, IOException {
		String text = FileUtils.readFileToString(new File(filename), "UTF-8");

		return loadXml(text.toString());
	}



	public static Tournament loadJsonFile(String filename) throws IOException {
		String text = FileUtils.readFileToString(new File(filename), "UTF-8");

		return loadJson(text.toString());
	}

	public static Tournament loadXml(String input) throws JAXBException{
		Tournament feed = new Tournament();
		if (input != null && input.trim().length() > 0) {
			JAXBContext docJc = JAXBContext.newInstance(Tournament.class);
			Unmarshaller unmarshaller = docJc.createUnmarshaller();
			StringReader strReader = new StringReader(input);
			feed = (Tournament)unmarshaller.unmarshal(strReader);
		}
		return feed;
	}

	public static String writeXml(Tournament input) throws JAXBException{
		JAXBContext docJc = JAXBContext.newInstance(Tournament.class);
		Marshaller marshaller = docJc.createMarshaller();
		marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, 
		Boolean.TRUE );
		marshaller.setProperty( Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, 
		"" );
		StringWriter writer = new StringWriter();
		marshaller.marshal(input, writer);
		return writer.toString();
	}

	public static Tournament loadJson(String json){
		Tournament obj = new Tournament();
		if (json != null && json.trim().length() > 0) {
			Gson gson = new Gson();			obj = gson.fromJson(json, Tournament.class);
		}
		return obj;
	}

	public static String writeJson(Tournament obj){
		Gson gson = new Gson();		String json = gson.toJson(obj);
		return json;
	}

	public static void main(String[] args) {
		try{
			Tournament obj = TournamentProcessor.loadXmlFile("/Users/jnowell/HELP/sdmf-config.xml");
		obj.toString();
		}catch(Exception e){
		e.printStackTrace();
		}

	}

	public static void mainJson(String[] args) {
		try{
			Tournament obj = TournamentProcessor.loadJsonFile("/Users/jnowell/HELP/sdmf-config.xml");
		obj.toString();
		}catch(Exception e){
		e.printStackTrace();
		}

	}

}
