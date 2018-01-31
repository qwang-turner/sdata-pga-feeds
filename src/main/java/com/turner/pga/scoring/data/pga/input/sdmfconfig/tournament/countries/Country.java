package com.turner.pga.scoring.data.pga.input.sdmfconfig.tournament.countries;
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


@XmlRootElement(name="country")
@XmlType(name="country",namespace="/tournament/countries")
public class Country {

	@SerializedName("COUNTRY_ID") private String COUNTRYId; //32
	@SerializedName("COUNTRY_ABRV") private String COUNTRYAbrv; //BRZ
	@SerializedName("LAST_UPDT_DT") private String LASTUpdtDt; //1308066458000
	@SerializedName("COUNTRY_NM") private String COUNTRYNm; //Brazilian
	@SerializedName("COUNTRY_FLAG") private String COUNTRYFlag; //BRZ


	
	
	@XmlAttribute(name="COUNTRY_ID")
	public String getCOUNTRYId(){
		return this.COUNTRYId;
	}

	 public void setCOUNTRYId(String COUNTRYId){
		this.COUNTRYId = COUNTRYId;
	}

	
	
	@XmlAttribute(name="COUNTRY_ABRV")
	public String getCOUNTRYAbrv(){
		return this.COUNTRYAbrv;
	}

	 public void setCOUNTRYAbrv(String COUNTRYAbrv){
		this.COUNTRYAbrv = COUNTRYAbrv;
	}

	
	
	@XmlAttribute(name="LAST_UPDT_DT")
	public String getLASTUpdtDt(){
		return this.LASTUpdtDt;
	}

	 public void setLASTUpdtDt(String LASTUpdtDt){
		this.LASTUpdtDt = LASTUpdtDt;
	}

	
	
	@XmlAttribute(name="COUNTRY_NM")
	public String getCOUNTRYNm(){
		return this.COUNTRYNm;
	}

	 public void setCOUNTRYNm(String COUNTRYNm){
		this.COUNTRYNm = COUNTRYNm;
	}

	
	
	@XmlAttribute(name="COUNTRY_FLAG")
	public String getCOUNTRYFlag(){
		return this.COUNTRYFlag;
	}

	 public void setCOUNTRYFlag(String COUNTRYFlag){
		this.COUNTRYFlag = COUNTRYFlag;
	}



}