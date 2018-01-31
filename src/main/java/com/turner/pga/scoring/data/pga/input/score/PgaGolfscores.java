package com.turner.pga.scoring.data.pga.input.score;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;
import com.turner.pga.scoring.data.pga.input.course.PgaGolfcourses;
import com.turner.pga.scoring.data.pga.input.score.golfscores.Rounds;
import com.turner.pga.scoring.data.pga.input.score.golfscores.rounds.round.Group;
import com.turner.pga.scoring.data.pga.input.score.golfscores.rounds.round.group.ScorePlayer;


@XmlRootElement(name="GolfScores")
@XmlType(name="GolfScores")
public class PgaGolfscores {

	@SerializedName("Rounds") private Rounds Rounds;


	
	@XmlElement(name="Rounds")
	public Rounds getRounds(){
		return this.Rounds;
	}

	 public void setRounds(Rounds Rounds){
		this.Rounds = Rounds;
	}

	public ScorePlayer findPlayer(String playerid, int rnd) {
		return Rounds.findPlayer(playerid, rnd);
	}

	public Group findGroup(String playerid, Integer rnd) {
		return Rounds.findGroup(playerid, rnd);
	}

	public void prepareData(PgaGolfcourses pgaCourses) {
		Rounds.prepareData(pgaCourses);
		
	}

	public List<ScorePlayer> findPlayer(String playerid) {
		List<ScorePlayer> playerList = new ArrayList<ScorePlayer>();
		for (int rnd = 1; rnd <= Rounds.getRoundList().size(); rnd++) {
			ScorePlayer player = findPlayer(playerid, rnd);
			if(player != null){
				playerList.add(player);
			}else{
				break;
			}
		}
		
		return playerList;
	}



}