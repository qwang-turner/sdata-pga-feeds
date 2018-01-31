package com.turner.pga.scoring.data.pga.input.setting;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;

public class PgasettingsProcessor {

	public static Pgasettings loadXmlFile(String filename) throws JAXBException, IOException {
		String text = FileUtils.readFileToString(new File(filename), "UTF-8");

		return loadXml(text);
	}

	public static Pgasettings loadJsonFile(String filename) throws IOException {
		String text = FileUtils.readFileToString(new File(filename), "UTF-8");

		return loadJson(text.toString());
	}

	public static Pgasettings loadXml(String input) throws JAXBException {
		Pgasettings feed = new Pgasettings();
		if (input != null && input.trim().length() > 0) {
			JAXBContext docJc = JAXBContext.newInstance(Pgasettings.class);
			Unmarshaller unmarshaller = docJc.createUnmarshaller();
			StringReader strReader = new StringReader(input);
			feed = (Pgasettings) unmarshaller.unmarshal(strReader);
		}
		return feed;
	}

	public static String writeXml(Pgasettings input) throws JAXBException {
		JAXBContext docJc = JAXBContext.newInstance(Pgasettings.class);
		Marshaller marshaller = docJc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "");
		StringWriter writer = new StringWriter();
		marshaller.marshal(input, writer);
		return writer.toString();
	}

	public static Pgasettings loadJson(String json) {
		Pgasettings obj = new Pgasettings();
		if (json != null && json.trim().length() > 0) {
			Gson gson = new Gson();
			obj = gson.fromJson(json, Pgasettings.class);
		}
		return obj;
	}

	public static String writeJson(Pgasettings obj) {
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		return json;
	}

	public static void main(String[] args) {
		try {
			Pgasettings obj = PgasettingsProcessor
					.loadXmlFile("/Users/jnowell/git/sdata-pga-scoring-receiver/data/test_input/PGA/pga_settings.xml");
			obj.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void mainJson(String[] args) {
		try {
			Pgasettings obj = PgasettingsProcessor
					.loadJsonFile("/Users/jnowell/git/sdata-pga-scoring-receiver/data/test_input/PGA/pga_settings.xml");
			obj.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
