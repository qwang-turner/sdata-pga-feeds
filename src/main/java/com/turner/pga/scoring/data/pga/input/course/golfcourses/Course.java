package com.turner.pga.scoring.data.pga.input.course.golfcourses;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;
import com.turner.pga.scoring.data.pga.input.course.golfcourses.course.Hole;


@XmlRootElement(name="Course")
@XmlType(name="Course",namespace="/GolfCourses")
public class Course {

	@SerializedName("Name") private String Name; //The Ocean Course
	@SerializedName("ShortName") private String ShortName; //
	@SerializedName("ID") private String ID; //1
	@SerializedName("Hole") private List<Hole> HoleList = new ArrayList<Hole>();
	
	private Integer yardage;
	private Integer par;
	private Integer frontPar;
	private Integer backPar;


	
	@XmlAttribute(name="Name")
	public String getName(){
		return this.Name;
	}

	 public void setName(String Name){
		this.Name = Name;
	}

	
	@XmlAttribute(name="ShortName")
	public String getShortName(){
		return this.ShortName;
	}

	 public void setShortName(String ShortName){
		this.ShortName = ShortName;
	}

	
	@XmlAttribute(name="ID")
	public String getID(){
		return this.ID;
	}

	 public void setID(String ID){
		this.ID = ID;
	}

	
	@XmlElement(name="Hole")
	public List<Hole> getHoleList(){
		return this.HoleList;
	}

	 public void setHoleList(List<Hole> HoleList){
		this.HoleList = HoleList;
	}

	public Integer getPar() {
		prepare();
		return this.par;
	}

	public Integer getBackPar() {
		prepare();
		return this.backPar;
	}

	public Integer getYardage() {
		prepare();
		return this.yardage;
	}

	public Integer getFrontPar() {
		prepare();
		return this.frontPar;
	}

	private void prepare() {
		if(this.yardage == null){
			this.backPar = 0;
			this.frontPar = 0;
			this.par = 0;
			this.yardage = 0;
		for (Hole hole : HoleList) {
			this.yardage += hole.getYardage();
			this.par += hole.getPar();
			if(hole.getID() < 10){
				this.frontPar += hole.getPar();
			}else{
				this.backPar += hole.getPar();
			}
		}
		}
		
	}



}