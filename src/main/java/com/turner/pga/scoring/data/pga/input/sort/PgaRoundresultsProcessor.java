package com.turner.pga.scoring.data.pga.input.sort;

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

public class PgaRoundresultsProcessor {

	public static PgaRoundresults loadXmlFile(String filename) throws IOException, JAXBException {
		String text = FileUtils.readFileToString(new File(filename), "UTF-8");

		return loadXml(text.toString());
	}

	public static PgaRoundresults loadJsonFile(String filename) throws IOException {
		String text = FileUtils.readFileToString(new File(filename), "UTF-8");

		return loadJson(text.toString());
	}

	public static PgaRoundresults loadXml(String input) throws JAXBException {
		PgaRoundresults feed = new PgaRoundresults();
		if (input != null && input.trim().length() > 0) {
			JAXBContext docJc = JAXBContext.newInstance(PgaRoundresults.class);
			Unmarshaller unmarshaller = docJc.createUnmarshaller();
			StringReader strReader = new StringReader(input);
			feed = (PgaRoundresults) unmarshaller.unmarshal(strReader);
		}
		return feed;
	}

	public static String writeXml(PgaRoundresults input) throws JAXBException {
		JAXBContext docJc = JAXBContext.newInstance(PgaRoundresults.class);
		Marshaller marshaller = docJc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "");
		StringWriter writer = new StringWriter();
		marshaller.marshal(input, writer);
		return writer.toString();
	}

	public static PgaRoundresults loadJson(String json) {
		PgaRoundresults obj = new PgaRoundresults();
		if (json != null && json.trim().length() > 0) {
			Gson gson = new Gson();
			obj = gson.fromJson(json, PgaRoundresults.class);
		}
		return obj;
	}

	public static String writeJson(PgaRoundresults obj) {
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		return json;
	}

	public static void main(String[] args) {
		try {
			PgaRoundresults obj = PgaRoundresultsProcessor
					.loadXmlFile("/Users/jnowell/git/sdata-pga-scoring-receiver/data/test_input/PGA/tvsort.xml");
			obj.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void mainJson(String[] args) {
		try {
			PgaRoundresults obj = PgaRoundresultsProcessor
					.loadJsonFile("/Users/jnowell/git/sdata-pga-scoring-receiver/data/test_input/PGA/tvsort.xml");
			obj.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
