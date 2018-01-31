package com.turner.pga.scoring.data.pga.input.player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;
import com.turner.pga.scoring.data.pga.input.player.golfplayers.Player;


@XmlRootElement(name="GolfPlayers")
@XmlType(name="GolfPlayers")
public class PgaGolfplayers {

	@SerializedName("Player") private List<Player> PlayerList = new ArrayList<Player>();
	
	private Map<String,Player> playerMap;


	
	@XmlElement(name="Player")
	public List<Player> getPlayerList(){
		return this.PlayerList;
	}

	 public void setPlayerList(List<Player> PlayerList){
		this.PlayerList = PlayerList;
	}

	public void prepareData() {
		if(playerMap == null){
			playerMap = new HashMap<String,Player>();
			for (Player player : PlayerList) {
				playerMap.put(player.getID(), player);
			}
		}
	}
	
	public Player findPlayer(String pgatourId){
		return playerMap.get(pgatourId);
	}



}