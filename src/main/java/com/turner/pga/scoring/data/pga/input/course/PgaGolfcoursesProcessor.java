package com.turner.pga.scoring.data.pga.input.course;

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

public class PgaGolfcoursesProcessor {

	public static PgaGolfcourses loadXmlFile(String filename) throws JAXBException, IOException {
		String text = FileUtils.readFileToString(new File(filename), "UTF-8");
		return loadXml(text);
	}

	public static PgaGolfcourses loadJsonFile(String filename) throws IOException {
		String text = FileUtils.readFileToString(new File(filename), "UTF-8");
		return loadJson(text);
	}

	public static PgaGolfcourses loadXml(String input) throws JAXBException {
		PgaGolfcourses feed = new PgaGolfcourses();
		if (input != null && input.trim().length() > 0) {
			JAXBContext docJc = JAXBContext.newInstance(PgaGolfcourses.class);
			Unmarshaller unmarshaller = docJc.createUnmarshaller();
			StringReader strReader = new StringReader(input);
			feed = (PgaGolfcourses) unmarshaller.unmarshal(strReader);
		}
		return feed;
	}

	public static String writeXml(PgaGolfcourses input) throws JAXBException {
		JAXBContext docJc = JAXBContext.newInstance(PgaGolfcourses.class);
		Marshaller marshaller = docJc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "");
		StringWriter writer = new StringWriter();
		marshaller.marshal(input, writer);
		return writer.toString();
	}

	public static PgaGolfcourses loadJson(String json) {
		PgaGolfcourses obj = new PgaGolfcourses();
		if (json != null && json.trim().length() > 0) {
			Gson gson = new Gson();
			obj = gson.fromJson(json, PgaGolfcourses.class);
		}
		return obj;
	}

	public static String writeJson(PgaGolfcourses obj) {
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		return json;
	}

	public static void main(String[] args) {
		try {
			PgaGolfcourses obj = PgaGolfcoursesProcessor
					.loadXmlFile("/Users/jnowell/git/sdata-pga-scoring-receiver/data/test_input/PGA/tvcourse.xml");
			obj.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void mainJson(String[] args) {
		try {
			PgaGolfcourses obj = PgaGolfcoursesProcessor
					.loadJsonFile("/Users/jnowell/git/sdata-pga-scoring-receiver/data/test_input/PGA/tvcourse.xml");
			obj.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
