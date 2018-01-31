package com.turner.pga.scoring.data.pga.input.sdmfconfig.tournament.players;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.List;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlRootElement;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;


@XmlRootElement(name="player")
@XmlType(name="player",namespace="/tournament/players")
public class Player {

	@SerializedName("CountryDisplay") private String CountryDisplay; //Japan
	@SerializedName("FIRST_NM") private String FIRSTNm; //Tsuyoshi
	@SerializedName("LAST_NM") private String LASTNm; //Yoneyama
	@SerializedName("LAST_UPDT_DT") private String LASTUpdtDt; //1369108800000
	@SerializedName("PLAYER_CNTRY") private String PLAYERCntry; //Japan
	@SerializedName("MailCountryID") private String MailCountryID; //237
	@SerializedName("PLAYER_ID") private String PLAYERId; //20944
	@SerializedName("DISPLAY_NM") private String DISPLAYNm; //Yoneyama
	@SerializedName("Club_Pro") private String ClubPro; //0
	@SerializedName("TOUR_ID") private String TOURId; //13574
	@SerializedName("PLAYER_FLAG") private String PLAYERFlag; //
	@SerializedName("Profile") private String Profile; //


	
	
	@XmlAttribute(name="CountryDisplay")
	public String getCountryDisplay(){
		return this.CountryDisplay;
	}

	 public void setCountryDisplay(String CountryDisplay){
		this.CountryDisplay = CountryDisplay;
	}

	
	
	@XmlAttribute(name="FIRST_NM")
	public String getFIRSTNm(){
		return this.FIRSTNm;
	}

	 public void setFIRSTNm(String FIRSTNm){
		this.FIRSTNm = FIRSTNm;
	}

	
	
	@XmlAttribute(name="LAST_NM")
	public String getLASTNm(){
		return this.LASTNm;
	}

	 public void setLASTNm(String LASTNm){
		this.LASTNm = LASTNm;
	}

	
	
	@XmlAttribute(name="LAST_UPDT_DT")
	public String getLASTUpdtDt(){
		return this.LASTUpdtDt;
	}

	 public void setLASTUpdtDt(String LASTUpdtDt){
		this.LASTUpdtDt = LASTUpdtDt;
	}

	
	
	@XmlAttribute(name="PLAYER_CNTRY")
	public String getPLAYERCntry(){
		return this.PLAYERCntry;
	}

	 public void setPLAYERCntry(String PLAYERCntry){
		this.PLAYERCntry = PLAYERCntry;
	}

	
	
	@XmlAttribute(name="MailCountryID")
	public String getMailCountryID(){
		return this.MailCountryID;
	}

	 public void setMailCountryID(String MailCountryID){
		this.MailCountryID = MailCountryID;
	}

	
	
	@XmlAttribute(name="PLAYER_ID")
	public String getPLAYERId(){
		return this.PLAYERId;
	}

	 public void setPLAYERId(String PLAYERId){
		this.PLAYERId = PLAYERId;
	}

	
	
	@XmlAttribute(name="DISPLAY_NM")
	public String getDISPLAYNm(){
		return this.DISPLAYNm;
	}

	 public void setDISPLAYNm(String DISPLAYNm){
		this.DISPLAYNm = DISPLAYNm;
	}

	
	
	@XmlAttribute(name="Club_Pro")
	public String getClubPro(){
		return this.ClubPro;
	}

	 public void setClubPro(String ClubPro){
		this.ClubPro = ClubPro;
	}

	
	
	@XmlAttribute(name="TOUR_ID")
	public String getTOURId(){
		return this.TOURId;
	}

	 public void setTOURId(String TOURId){
		this.TOURId = TOURId;
	}

	
	
	@XmlAttribute(name="PLAYER_FLAG")
	public String getPLAYERFlag(){
		return this.PLAYERFlag;
	}

	 public void setPLAYERFlag(String PLAYERFlag){
		this.PLAYERFlag = PLAYERFlag;
	}

	
	
	@XmlElement(name="Profile")
	public String getProfile(){
		return this.Profile;
	}

	 public void setProfile(String Profile){
		this.Profile = Profile;
	}



}