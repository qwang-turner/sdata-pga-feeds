package com.turner.pga.scoring.data.pga.input.sdmfconfig;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.List;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.XmlTransient;
import com.turner.pga.scoring.data.pga.input.sdmfconfig.tournament.countries.Country;
import javax.xml.bind.annotation.XmlRootElement;
import com.google.gson.annotations.SerializedName;
import com.turner.pga.scoring.data.pga.input.sdmfconfig.tournament.players.Player;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.bind.annotation.XmlElement;


@XmlRootElement(name="tournament")
@XmlType(name="tournament")
public class Tournament {

	@SerializedName("player") private List<Player> playerList = new ArrayList<Player>();
	@SerializedName("country") private List<Country> countryList = new ArrayList<Country>();

	
	@XmlElementWrapper(name = "players")
	@XmlElement(name="player")
	public List<Player> getPlayerList(){
		return this.playerList;
	}

	 public void setPlayerList(List<Player> playerList){
		this.playerList = playerList;
	}

	
	@XmlElementWrapper(name = "countries")
	@XmlElement(name="country")
	public List<Country> getCountryList(){
		return this.countryList;
	}

	 public void setCountryList(List<Country> countryList){
		this.countryList = countryList;
	}

	public Player findPlr(String id) {
		Collections.sort(playerList, new PlayerIDComparator());
		Player key = new Player();
		key.setPLAYERId(id);
		Integer index = Collections.binarySearch(playerList, key, new PlayerIDComparator());
		Player plr = null;
		if(index > 0){
			plr = playerList.get(index); 
		}
		
		return plr;
	}



}