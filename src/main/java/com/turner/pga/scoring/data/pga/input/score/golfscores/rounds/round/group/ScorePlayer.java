package com.turner.pga.scoring.data.pga.input.score.golfscores.rounds.round.group;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;
import com.turner.pga.scoring.data.pga.input.course.golfcourses.Course;
import com.turner.pga.scoring.data.pga.input.course.golfcourses.course.Hole;
import com.turner.pga.scoring.data.pga.input.util.GolfFormat;


@XmlRootElement(name="Player")
@XmlType(name="Player",namespace="/GolfScores/Rounds/Round/Group")
public class ScorePlayer {

	@SerializedName("Status") private String Status; //WIN
	@SerializedName("Scores") private String Scores; //5,5,4,5,5,3,4,3,4,3,5,3,4,,,,,
	@SerializedName("ID") private String ID; //80008
	@SerializedName("PGAHQID") private String PGAHQID; //10494
	
	@XmlTransient private List<ScoreDetail> details = new ArrayList<ScoreDetail>();
	@XmlTransient private String course;
	@XmlTransient private Calendar TTime;
	@XmlTransient private Integer start;
	@XmlTransient private String parRelative;
	@XmlTransient private Integer back;
	@XmlTransient private Integer front;
	@XmlTransient private Integer strokes;
	@XmlTransient private Integer rnd;
	@XmlTransient private Integer thru;


	
	@XmlAttribute(name="Status")
	public String getStatus(){
		return this.Status;
	}

	 public void setStatus(String Status){
		this.Status = Status;
	}

	
	@XmlAttribute(name="Scores")
	public String getScores(){
		return this.Scores;
	}

	 public void setScores(String Scores){
		this.Scores = Scores;
	}

	
	@XmlAttribute(name="ID")
	public String getID(){
		return this.ID;
	}

	 public void setID(String ID){
		this.ID = ID;
	}

	
	@XmlAttribute(name="PGAHQID")
	public String getPGAHQID(){
		return this.PGAHQID;
	}

	 public void setPGAHQID(String PGAHQID){
		this.PGAHQID = PGAHQID;
	}

	public void prepareData(Course course) {
		this.course = course.getID();
		String[] splitScores = Scores.split(",");
		if(splitScores.length < 18){
			splitScores = Arrays.copyOf(splitScores, 18);
			for (int i = 0; i < splitScores.length; i++) {
				if(splitScores[i] == null){
					splitScores[i] = "";
				}
			}
		}
		int hole = 1;
		int thru = 0;
		int parTotal = 0;
		int strokeTotal = 0;
		
		int backCount = 0;
		int backTotal = 0;
		int frontCount = 0;
		int frontTotal = 0;
		for (String holeScore : splitScores) {
			
			Hole holeInfo = course.getHoleList().get(hole-1);
			if(holeScore.equalsIgnoreCase("")){
				holeScore = "0";
			}
			
			Integer strokes = new Integer(holeScore);
			String relativeScore = "E";
			if(strokes > 0){
				thru++;
				parTotal += holeInfo.getPar();
				strokeTotal += strokes;
				
				relativeScore = GolfFormat.formatScore(strokes - holeInfo.getPar());
				
				if(hole <= 9){
					//front
					frontCount++;
					frontTotal += strokes;
				}else{
					backCount++;
					backTotal += strokes;
				}
			}
			
			this.front = (frontCount == 9)?frontTotal:0;
			this.back = (backCount == 9)?backTotal:0;
			this.strokes = (frontCount == 9 && backCount == 9)?this.front + this.back:0;
			
			ScoreDetail detail = new ScoreDetail();
			detail.setStrokes(strokes);
			detail.setParRelative(relativeScore);
			detail.setHoleNum(hole);
			detail.setYardage(holeInfo.getYardage());
			detail.setPar(holeInfo.getPar());
			
			details.add(detail );
			
			hole++;
			
		}
		
		this.thru = thru;
		this.setParRelative(GolfFormat.formatScore(strokeTotal - parTotal));
		
	}

	/**
	 * @return the details
	 */
	public List<ScoreDetail> getDetails() {
		return details;
	}

	/**
	 * @return the tTime
	 */
	public Calendar getTTime() {
		return TTime;
	}

	/**
	 * @param tTime the tTime to set
	 */
	public void setTTime(Calendar TTime) {
		this.TTime = TTime;
	}

	/**
	 * @return the start
	 */
	public Integer getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(Integer start) {
		this.start = start;
	}

	/**
	 * @return the parRelativel
	 */
	public String getParRelative() {
		return parRelative;
	}

	/**
	 * @param parRelativel the parRelativel to set
	 */
	public void setParRelative(String parRelative) {
		this.parRelative = parRelative;
	}

	/**
	 * @return the back
	 */
	public Integer getBack() {
		return back;
	}

	/**
	 * @return the front
	 */
	public Integer getFront() {
		return front;
	}

	/**
	 * @return the strokes
	 */
	public Integer getStrokes() {
		return strokes;
	}

	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * @return the rnd
	 */
	public Integer getRnd() {
		return rnd;
	}

	/**
	 * @param rnd the rnd to set
	 */
	public void setRnd(Integer rnd) {
		this.rnd = rnd;
	}

	/**
	 * @return the thru
	 */
	public Integer getThru() {
		return thru;
	}



}