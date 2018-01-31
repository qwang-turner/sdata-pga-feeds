package com.turner.pga.scoring.data.pga.input.score.golfscores.rounds.round;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.gson.annotations.SerializedName;
import com.turner.pga.scoring.data.pga.input.score.golfscores.rounds.round.group.ScorePlayer;


@XmlRootElement(name="Group")
@XmlType(name="Group",namespace="/GolfScores/Rounds/Round")
public class Group {

	@SerializedName("Course") private String Course; //1
	@SerializedName("Start") private Integer Start; //1
	@SerializedName("ID") private Integer ID; //1
	@SerializedName("TTime") private Calendar TTime; //7:00
	@SerializedName("Player") private List<ScorePlayer> PlayerList = new ArrayList<ScorePlayer>();


	
	@XmlAttribute(name="Course")
	public String getCourse(){
		return this.Course;
	}

	 public void setCourse(String Course){
		this.Course = Course;
	}

	
	@XmlAttribute(name="Start")
	public Integer getStart(){
		return this.Start;
	}

	 public void setStart(Integer Start){
		this.Start = Start;
	}

	
	@XmlAttribute(name="ID")
	public Integer getID(){
		return this.ID;
	}

	 public void setID(Integer ID){
		this.ID = ID;
	}

	
	@XmlAttribute(name="TTime")
	@XmlJavaTypeAdapter(PGATeeTimeAdapter.class)
	public Calendar getTTime(){
		return this.TTime;
	}

	 public void setTTime(Calendar TTime){
		this.TTime = TTime;
	}

	
	@XmlElement(name="Player")
	public List<ScorePlayer> getPlayerList(){
		return this.PlayerList;
	}

	 public void setPlayerList(List<ScorePlayer> PlayerList){
		this.PlayerList = PlayerList;
	}



}