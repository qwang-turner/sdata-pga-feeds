package com.turner.pga.scoring.data.pga.input.score;

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

public class PgaGolfscoresProcessor {

	public static PgaGolfscores loadXmlFile(String filename) throws JAXBException, IOException {
		String text = FileUtils.readFileToString(new File(filename), "UTF-8");

		return loadXml(text.toString());
	}

	public static PgaGolfscores loadJsonFile(String filename) throws IOException {
		String text = FileUtils.readFileToString(new File(filename), "UTF-8");

		return loadJson(text.toString());
	}

	public static PgaGolfscores loadXml(String input) throws JAXBException {
		PgaGolfscores feed = new PgaGolfscores();
		if (input != null && input.trim().length() > 0) {
			JAXBContext docJc = JAXBContext.newInstance(PgaGolfscores.class);
			Unmarshaller unmarshaller = docJc.createUnmarshaller();
			StringReader strReader = new StringReader(input);
			feed = (PgaGolfscores) unmarshaller.unmarshal(strReader);
		}
		return feed;
	}

	public static String writeXml(PgaGolfscores input) throws JAXBException {
		JAXBContext docJc = JAXBContext.newInstance(PgaGolfscores.class);
		Marshaller marshaller = docJc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "");
		StringWriter writer = new StringWriter();
		marshaller.marshal(input, writer);
		return writer.toString();
	}

	public static PgaGolfscores loadJson(String json) {
		PgaGolfscores obj = new PgaGolfscores();
		if (json != null && json.trim().length() > 0) {
			Gson gson = new Gson();
			obj = gson.fromJson(json, PgaGolfscores.class);
		}
		return obj;
	}

	public static String writeJson(PgaGolfscores obj) {
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		return json;
	}

	public static void main(String[] args) {
		try {
			PgaGolfscores obj = PgaGolfscoresProcessor
					.loadXmlFile("/Users/jnowell/git/sdata-pga-scoring-receiver/data/test_input/PGA/tvscore.xml");
			obj.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void mainJson(String[] args) {
		try {
			PgaGolfscores obj = PgaGolfscoresProcessor
					.loadJsonFile("/Users/jnowell/git/sdata-pga-scoring-receiver/data/test_input/PGA/tvscore.xml");
			obj.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
