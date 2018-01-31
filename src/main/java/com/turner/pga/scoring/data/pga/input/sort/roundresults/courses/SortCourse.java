package com.turner.pga.scoring.data.pga.input.sort.roundresults.courses;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;


@XmlRootElement(name="course")
@XmlType(name="course",namespace="/roundresults/courses")
public class SortCourse {

	@SerializedName("name") private String name; //The Ocean Course
	@SerializedName("shortname") private String shortname; //


	
	@XmlElement(name="name")
	public String getName(){
		return this.name;
	}

	 public void setName(String name){
		this.name = name;
	}

	
	@XmlElement(name="shortname")
	public String getShortname(){
		return this.shortname;
	}

	 public void setShortname(String shortname){
		this.shortname = shortname;
	}



}