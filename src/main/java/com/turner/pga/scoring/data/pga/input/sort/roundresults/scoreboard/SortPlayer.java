package com.turner.pga.scoring.data.pga.input.sort.roundresults.scoreboard;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "player")
@XmlType(name = "player", namespace = "/roundresults/scoreboard")
public class SortPlayer {

	@SerializedName("course")
	private String course; //
	@SerializedName("externalid")
	private String externalid; // 22655
	@SerializedName("thru")
	private String thru; //
	@SerializedName("sortorder")
	private Integer sortorder; // 144
	@SerializedName("displaycutline")
	private String displaycutline; // Projected After Round 2 - Cut to low 70 +
									// ties
	@SerializedName("lastname")
	private String lastname; // Bruner
	@SerializedName("informalname")
	private String informalname; // Jerry
	@SerializedName("playerid")
	private String playerid; // 11029
	@SerializedName("place")
	private String place; // T83
	@SerializedName("in")
	private Integer in; // 79
	@SerializedName("totalscore")
	private String totalscore; // E
	@SerializedName("holesplayed")
	private Integer holesplayed; // 0
	@SerializedName("out")
	private Integer out; // 40
	
	@SerializedName("shotstotal")
	private Integer shotstotal; // 40
	
	@SerializedName("shotsr1")
	private Integer shotsr1; // 40
	@SerializedName("shotsr2")
	private Integer shotsr2; // 40
	@SerializedName("shotsr3")
	private Integer shotsr3; // 40
	@SerializedName("shotsr4")
	private Integer shotsr4; // 40

	@XmlTransient
	private Integer lastCompleteRound;
	@XmlTransient
	private Integer previousStrokes;
	@XmlTransient
	private String startingPlace;

	@XmlElement(name = "course")
	public String getCourse() {
		return this.course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@XmlElement(name = "externalid")
	public String getExternalid() {
		return this.externalid;
	}

	public void setExternalid(String externalid) {
		this.externalid = externalid;
	}

	@XmlElement(name = "thru")
	public String getThru() {
		return this.thru;
	}

	public void setThru(String thru) {
		this.thru = thru;
	}

	@XmlElement(name = "sortorder")
	public Integer getSortorder() {
		return this.sortorder;
	}

	public void setSortorder(Integer sortorder) {
		this.sortorder = sortorder;
	}

	@XmlElement(name = "displaycutline")
	public String getDisplaycutline() {
		return this.displaycutline;
	}

	public void setDisplaycutline(String displaycutline) {
		this.displaycutline = displaycutline;
	}

	@XmlElement(name = "lastname")
	@XmlJavaTypeAdapter(CleanStringAdapter.class)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@XmlElement(name = "informalname")
	@XmlJavaTypeAdapter(CleanStringAdapter.class)
	public String getInformalname() {
		return this.informalname;
	}

	public void setInformalname(String informalname) {
		this.informalname = informalname;
	}

	@XmlElement(name = "playerid")
	public String getPlayerid() {
		return this.playerid;
	}

	public void setPlayerid(String playerid) {
		this.playerid = playerid;
	}

	@XmlElement(name = "place")
	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@XmlElement(name = "in")
	public Integer getIn() {
		return this.in;
	}

	public void setIn(Integer in) {
		this.in = in;
	}

	@XmlElement(name = "totalscore")
	public String getTotalscore() {
		return this.totalscore;
	}

	public void setTotalscore(String totalscore) {
		this.totalscore = totalscore;
	}

	@XmlElement(name = "holesplayed")
	public Integer getHolesplayed() {
		return this.holesplayed;
	}

	public void setHolesplayed(Integer holesplayed) {
		this.holesplayed = holesplayed;
	}

	@XmlElement(name = "out")
	public Integer getOut() {
		return this.out;
	}

	public void setOut(Integer out) {
		this.out = out;
	}

	@XmlElement(name = "shotstotal")
	public Integer getShotstotal() {
		return this.shotstotal;
	}

	public void setShotstotal(Integer shotstotal) {
		this.shotstotal = shotstotal;
	}

	/**
	 * @return the lastCompleteRound
	 */
	public Integer getLastCompleteRound() {
		return lastCompleteRound;
	}

	/**
	 * @param lastCompleteRound
	 *            the lastCompleteRound to set
	 */
	public void setLastCompleteRound(Integer lastCompleteRound) {
		this.lastCompleteRound = lastCompleteRound;
	}

	/**
	 * @return the previousStrokes
	 */
	public Integer getPreviousStrokes() {
		return previousStrokes;
	}

	/**
	 * @param previousStrokes
	 *            the previousStrokes to set
	 */
	public void setPreviousStrokes(Integer previousStrokes) {
		this.previousStrokes = previousStrokes;
	}

	/**
	 * @return the startingPlace
	 */
	public String getStartingPlace() {
		return startingPlace;
	}

	/**
	 * @param startingPlace
	 *            the startingPlace to set
	 */
	public void setStartingPlace(String startingPlace) {
		this.startingPlace = startingPlace;
	}

	public Integer calculateShotstotal() {
		Integer calTotalStrokes = 0;
		calTotalStrokes += (shotsr1 != null)?shotsr1:0;
		calTotalStrokes += (shotsr2 != null)?shotsr2:0;
		calTotalStrokes += (shotsr3 != null)?shotsr3:0;
		calTotalStrokes += (shotsr4 != null)?shotsr4:0;
		return calTotalStrokes;
	}

	/**
	 * @return the shotsr1
	 */
	public Integer getShotsr1() {
		return shotsr1;
	}

	/**
	 * @param shotsr1 the shotsr1 to set
	 */
	public void setShotsr1(Integer shotsr1) {
		this.shotsr1 = shotsr1;
	}

	/**
	 * @return the shotsr2
	 */
	public Integer getShotsr2() {
		return shotsr2;
	}

	/**
	 * @param shotsr2 the shotsr2 to set
	 */
	public void setShotsr2(Integer shotsr2) {
		this.shotsr2 = shotsr2;
	}

	/**
	 * @return the shotsr3
	 */
	public Integer getShotsr3() {
		return shotsr3;
	}

	/**
	 * @param shotsr3 the shotsr3 to set
	 */
	public void setShotsr3(Integer shotsr3) {
		this.shotsr3 = shotsr3;
	}

	/**
	 * @return the shotsr4
	 */
	public Integer getShotsr4() {
		return shotsr4;
	}

	/**
	 * @param shotsr4 the shotsr4 to set
	 */
	public void setShotsr4(Integer shotsr4) {
		this.shotsr4 = shotsr4;
	}

}