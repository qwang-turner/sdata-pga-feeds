package com.turner.pga.scoring.data.pga.input.player;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.turner.pga.scoring.data.pga.input.player.golfplayers.Player;
import com.turner.pga.scoring.data.pga.input.sdmfconfig.Tournament;
import com.turner.pga.scoring.data.pga.input.sdmfconfig.TournamentProcessor;
import com.turner.pga.scoring.data.pga.input.sdmfconfig.tournament.countries.Country;

public class PgaGolfplayersProcessor {

	public static PgaGolfplayers loadXmlFile(String filename) throws JAXBException, IOException {
		String text = FileUtils.readFileToString(new File(filename), "UTF-8");

		return loadXml(text.toString());
	}

	public static PgaGolfplayers loadJsonFile(String filename) throws IOException {
		String text = FileUtils.readFileToString(new File(filename), "UTF-8");

		return loadJson(text.toString());
	}

	public static PgaGolfplayers loadXml(String input) throws JAXBException {
		PgaGolfplayers feed = new PgaGolfplayers();
		if (input != null && input.trim().length() > 0) {
			JAXBContext docJc = JAXBContext.newInstance(PgaGolfplayers.class);
			Unmarshaller unmarshaller = docJc.createUnmarshaller();
			StringReader strReader = new StringReader(input);
			feed = (PgaGolfplayers) unmarshaller.unmarshal(strReader);
		}
		return feed;
	}

	public static String writeXml(PgaGolfplayers input) throws JAXBException {
		JAXBContext docJc = JAXBContext.newInstance(PgaGolfplayers.class);
		Marshaller marshaller = docJc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "");
		StringWriter writer = new StringWriter();
		marshaller.marshal(input, writer);
		return writer.toString();
	}

	public static PgaGolfplayers loadJson(String json) {
		PgaGolfplayers obj = new PgaGolfplayers();
		if (json != null && json.trim().length() > 0) {
			Gson gson = new Gson();
			obj = gson.fromJson(json, PgaGolfplayers.class);

		}
		return obj;
	}

	public static String writeJson(PgaGolfplayers obj) {
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		return json;
	}

	public static void main(String[] args) {
		try {
			PgaGolfplayers obj = PgaGolfplayersProcessor
					.loadXmlFile("/Users/jnowell/HELP/tvplayer.xml");
			
			Tournament findTrn = TournamentProcessor.loadXmlFile("/Users/jnowell/HELP/sdmf-config-known.xml");
			
			
			Tournament trn = new Tournament();
			List<com.turner.pga.scoring.data.pga.input.sdmfconfig.tournament.players.Player> playerList = new ArrayList<com.turner.pga.scoring.data.pga.input.sdmfconfig.tournament.players.Player>();
			for (Player plr : obj.getPlayerList()) {
				com.turner.pga.scoring.data.pga.input.sdmfconfig.tournament.players.Player sdPlr = new com.turner.pga.scoring.data.pga.input.sdmfconfig.tournament.players.Player();
				com.turner.pga.scoring.data.pga.input.sdmfconfig.tournament.players.Player findPlr = findTrn.findPlr(plr.getID());
				
	
				sdPlr.setClubPro(plr.getClubPro()+"");
				String countryDisplay = (findPlr != null)? findPlr.getCountryDisplay():"United States";
				sdPlr.setCountryDisplay(countryDisplay );
				sdPlr.setDISPLAYNm(plr.getLastName().toUpperCase());
				sdPlr.setFIRSTNm(plr.getFirstName());
				sdPlr.setLASTNm(plr.getLastName());
				sdPlr.setLASTUpdtDt("1369108800000");
				sdPlr.setMailCountryID("");
				sdPlr.setPLAYERCntry(countryDisplay);
				String flag = (plr.getClubPro() == 1)?"C":"";
				sdPlr.setPLAYERFlag(flag);
				sdPlr.setPLAYERId(plr.getID());
				sdPlr.setProfile("");
				sdPlr.setTOURId(plr.getPgahqid());
				
				
				
				playerList.add(sdPlr);
			}
			
			
			trn.setPlayerList(playerList);
			trn.setCountryList(findTrn.getCountryList());
			
			
			
			String data = TournamentProcessor.writeXml(trn);
			FileUtils.writeStringToFile(new File("/Users/jnowell/HELP/sdmf-config-pnc-2017.xml"), data, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
