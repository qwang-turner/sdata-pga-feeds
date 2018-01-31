package com.turner.pga.scoring.data.pga.input.sort.roundresults;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;
import com.turner.pga.scoring.data.pga.input.score.PgaGolfscores;
import com.turner.pga.scoring.data.pga.input.score.golfscores.rounds.round.group.ScorePlayer;
import com.turner.pga.scoring.data.pga.input.sort.roundresults.scoreboard.SortPlayer;


@XmlRootElement(name="scoreboard")
@XmlType(name="scoreboard",namespace="/roundresults")
public class Scoreboard {

	@SerializedName("player") private List<SortPlayer> playerList = new ArrayList<SortPlayer>();
	
	@XmlTransient private Map<String,SortPlayer> plrMap = new HashMap<String,SortPlayer>();


	
	@XmlElement(name="player")
	public List<SortPlayer> getPlayerList(){
		return this.playerList;
	}

	 public void setPlayerList(List<SortPlayer> playerList){
		this.playerList = playerList;
	}

	public void prepareData(PgaGolfscores pgaScores, Integer currentround) {
		List<SortPlayer> prvPlrList = new ArrayList<SortPlayer>(playerList);
		for (SortPlayer sortPlayer : prvPlrList) {
			int prvStrokes = 0;
			int lastRnd = 0;
			for (int i = 1; i < currentround; i++) {
				ScorePlayer scorePlr = pgaScores.findPlayer(sortPlayer.getPlayerid(), i);
				if(scorePlr != null && scorePlr.getStrokes() != null){
					prvStrokes += scorePlr.getStrokes();
					lastRnd = i;
				}else{
					break;
				}
			}
			
			
			sortPlayer.setPreviousStrokes(prvStrokes);
			sortPlayer.setLastCompleteRound(lastRnd);
		}
		
		Collections.sort(prvPlrList, new PgaReviousRoundComparator());
		int prvPosition = 0;
		SortPlayer compPlayer = new SortPlayer();
		compPlayer.setPreviousStrokes(0);
		for (SortPlayer sortPlayer : prvPlrList) {
			if(sortPlayer.getPreviousStrokes() != compPlayer.getPreviousStrokes()){
				prvPosition++;
				sortPlayer.setStartingPlace(prvPosition + "");
			}else{
				sortPlayer.setStartingPlace("T" + prvPosition);
				compPlayer.setStartingPlace("T" + prvPosition);
			}
			plrMap.put(sortPlayer.getPlayerid(), sortPlayer);
		}
		
		
	}

	public SortPlayer findPlayer(String playerId) {
		return plrMap.get(playerId);
	}



}