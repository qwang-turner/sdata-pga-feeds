package com.turner.pga.scoring.data.pga.input.player.golfplayers;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;


@XmlRootElement(name="Player")
@XmlType(name="Player",namespace="/GolfPlayers")
public class Player {

	@SerializedName("Club_Pro") private Integer ClubPro; //0
	@SerializedName("Cut_Status") private Integer CutStatus; //0
	@SerializedName("pgahqid") private String pgahqid; //10802
	@SerializedName("ID") private String ID; //910802
	@SerializedName("Current_Round") private Integer CurrentRound; //
	@SerializedName("FirstName") private String FirstName; //Clint
	@SerializedName("LastName") private String LastName; //Ables
	@SerializedName("Country") private String Country; //
	@SerializedName("CountryDisplay") private String CountryDisplay; //
	@SerializedName("MailCountryID") private Integer MailCountryID; //237


	
	@XmlAttribute(name="Club_Pro")
	public Integer getClubPro(){
		return this.ClubPro;
	}

	 public void setClubPro(Integer ClubPro){
		this.ClubPro = ClubPro;
	}

	
	@XmlAttribute(name="Cut_Status")
	public Integer getCutStatus(){
		return this.CutStatus;
	}

	 public void setCutStatus(Integer CutStatus){
		this.CutStatus = CutStatus;
	}

	
	@XmlAttribute(name="pgahqid")
	public String getPgahqid(){
		return this.pgahqid;
	}

	 public void setPgahqid(String pgahqid){
		this.pgahqid = pgahqid;
	}

	
	@XmlAttribute(name="ID")
	public String getID(){
		return this.ID;
	}

	 public void setID(String ID){
		this.ID = ID;
	}

	
	@XmlAttribute(name="Current_Round")
	public Integer getCurrentRound(){
		return this.CurrentRound;
	}

	 public void setCurrentRound(Integer CurrentRound){
		this.CurrentRound = CurrentRound;
	}

	
	@XmlAttribute(name="FirstName")
	public String getFirstName(){
		return this.FirstName;
	}

	 public void setFirstName(String FirstName){
		this.FirstName = FirstName;
	}

	
	@XmlAttribute(name="LastName")
	public String getLastName(){
		return this.LastName;
	}

	 public void setLastName(String LastName){
		this.LastName = LastName;
	}

	
	@XmlAttribute(name="Country")
	public String getCountry(){
		return this.Country;
	}

	 public void setCountry(String Country){
		this.Country = Country;
	}

	
	@XmlAttribute(name="CountryDisplay")
	public String getCountryDisplay(){
		return this.CountryDisplay;
	}

	 public void setCountryDisplay(String CountryDisplay){
		this.CountryDisplay = CountryDisplay;
	}

	
	@XmlAttribute(name="MailCountryID")
	public Integer getMailCountryID(){
		return this.MailCountryID;
	}

	 public void setMailCountryID(Integer MailCountryID){
		this.MailCountryID = MailCountryID;
	}



}