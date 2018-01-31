package com.turner.pga.scoring.data.pga.input.course.golfcourses.course;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;


@XmlRootElement(name="Hole")
@XmlType(name="Hole",namespace="/GolfCourses/Course")
public class Hole {

	@SerializedName("Yardage") private Integer Yardage; //396
	@SerializedName("ID") private Integer ID; //1
	@SerializedName("Par") private Integer Par; //4


	
	@XmlAttribute(name="Yardage")
	public Integer getYardage(){
		return this.Yardage;
	}

	 public void setYardage(Integer Yardage){
		this.Yardage = Yardage;
	}

	
	@XmlAttribute(name="ID")
	public Integer getID(){
		return this.ID;
	}

	 public void setID(Integer ID){
		this.ID = ID;
	}

	
	@XmlAttribute(name="Par")
	public Integer getPar(){
		return this.Par;
	}

	 public void setPar(Integer Par){
		this.Par = Par;
	}



}