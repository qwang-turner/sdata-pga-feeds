package com.turner.pga.scoring.data.pga.input.sort;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;
import com.turner.pga.scoring.data.pga.input.score.PgaGolfscores;
import com.turner.pga.scoring.data.pga.input.sort.roundresults.Courses;
import com.turner.pga.scoring.data.pga.input.sort.roundresults.Scoreboard;
import com.turner.pga.scoring.data.pga.input.sort.roundresults.scoreboard.SortPlayer;


@XmlRootElement(name="roundresults")
@XmlType(name="roundresults")
public class PgaRoundresults {

	@SerializedName("enableplayerholebyhole") private String enableplayerholebyhole; //true
	@SerializedName("currentround") private Integer currentround = 1; //1
	@SerializedName("eventid") private Integer eventid = 0; //5000
	@SerializedName("eventname") private String eventname = ""; //PGA Champ Test
	@SerializedName("scoreboard") private Scoreboard scoreboard = new Scoreboard();
	@SerializedName("courses") private Courses courses = new Courses();


	
	@XmlElement(name="enableplayerholebyhole")
	public String getEnableplayerholebyhole(){
		return this.enableplayerholebyhole;
	}

	 public void setEnableplayerholebyhole(String enableplayerholebyhole){
		this.enableplayerholebyhole = enableplayerholebyhole;
	}

	
	@XmlElement(name="currentround")
	public Integer getCurrentround(){
		return this.currentround;
	}

	 public void setCurrentround(Integer currentround){
		this.currentround = currentround;
	}

	
	@XmlElement(name="eventid")
	public Integer getEventid(){
		return this.eventid;
	}

	 public void setEventid(Integer eventid){
		this.eventid = eventid;
	}

	
	@XmlElement(name="eventname")
	public String getEventname(){
		return this.eventname;
	}

	 public void setEventname(String eventname){
		this.eventname = eventname;
	}

	
	@XmlElement(name="scoreboard")
	public Scoreboard getScoreboard(){
		return this.scoreboard;
	}

	 public void setScoreboard(Scoreboard scoreboard){
		this.scoreboard = scoreboard;
	}

	
	@XmlElement(name="courses")
	public Courses getCourses(){
		return this.courses;
	}

	 public void setCourses(Courses courses){
		this.courses = courses;
	}

	public void prepareData(PgaGolfscores pgaScores) {
		scoreboard.prepareData(pgaScores,currentround);
	}
	
	public SortPlayer findPlayer(String playerId){
		return scoreboard.findPlayer(playerId);
	}



}