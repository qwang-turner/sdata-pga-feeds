package com.turner.pga.scoring.data.pga.input.course;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;
import com.turner.pga.scoring.data.pga.input.course.golfcourses.Course;


@XmlRootElement(name="GolfCourses")
@XmlType(name="GolfCourses")
public class PgaGolfcourses {

	@SerializedName("Course") private List<Course> CourseList;
	
	private Map<String,Course> crsMap = new HashMap<String,Course>();


	
	@XmlElement(name="Course")
	public List<Course> getCourseList(){
		return this.CourseList;
	}

	 public void setCourseList(List<Course> CourseList){
		this.CourseList = CourseList;
	}

	public Course findCourse(String crsCode) {
		prepareData();
		return crsMap.get(crsCode);
	}

	public void prepareData() {
		if(crsMap.size() == 0){
			for (Course course : CourseList) {
				crsMap.put(course.getID(), course);
			}
		}
	}



}