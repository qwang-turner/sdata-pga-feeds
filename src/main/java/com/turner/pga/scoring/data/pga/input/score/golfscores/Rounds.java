package com.turner.pga.scoring.data.pga.input.score.golfscores;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;
import com.turner.pga.scoring.data.pga.input.course.PgaGolfcourses;
import com.turner.pga.scoring.data.pga.input.score.golfscores.rounds.Round;
import com.turner.pga.scoring.data.pga.input.score.golfscores.rounds.round.Group;
import com.turner.pga.scoring.data.pga.input.score.golfscores.rounds.round.group.ScorePlayer;


@XmlRootElement(name="Rounds")
@XmlType(name="Rounds",namespace="/GolfScores")
public class Rounds {

	@SerializedName("Curr") private Integer Curr; //1
	@SerializedName("Round") private List<Round> RoundList = new ArrayList<Round>();


	
	@XmlAttribute(name="Curr")
	public Integer getCurr(){
		return this.Curr;
	}

	 public void setCurr(Integer Curr){
		this.Curr = Curr;
	}

	
	@XmlElement(name="Round")
	public List<Round> getRoundList(){
		return this.RoundList;
	}

	 public void setRoundList(List<Round> RoundList){
		this.RoundList = RoundList;
	}

	public ScorePlayer findPlayer(String playerId, int rnd) {
		ScorePlayer sc = null;
		if(rnd > 0 && rnd <= RoundList.size()){
			sc = RoundList.get(rnd - 1).findPlayer(playerId);
		}
		return sc;
	}

	public Group findGroup(String playerid, Integer rnd) {
		Group group = null;
		if(rnd > 0 && rnd <= RoundList.size()){
			group = RoundList.get(rnd - 1).findGroup(playerid);
		}
		return group;
	}

	public void prepareData(PgaGolfcourses pgaCourses) {
		for (Round round : RoundList) {
			round.prepareData(pgaCourses);
		}
	}



}