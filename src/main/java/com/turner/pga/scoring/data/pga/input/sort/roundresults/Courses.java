package com.turner.pga.scoring.data.pga.input.sort.roundresults;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;
import com.turner.pga.scoring.data.pga.input.sort.roundresults.courses.SortCourse;


@XmlRootElement(name="courses")
@XmlType(name="courses",namespace="/roundresults")
public class Courses {

	@SerializedName("course") private SortCourse course;


	
	@XmlElement(name="course")
	public SortCourse getCourse(){
		return this.course;
	}

	 public void setCourse(SortCourse course){
		this.course = course;
	}



}