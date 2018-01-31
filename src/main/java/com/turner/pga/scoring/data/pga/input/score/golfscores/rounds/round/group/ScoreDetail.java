package com.turner.pga.scoring.data.pga.input.score.golfscores.rounds.round.group;

public class ScoreDetail {
	
	private Integer holeNum;
	private Integer strokes;
	private String parRelative;
	private Integer yardage;
	private Integer par;
	
	/**
	 * @return the holeNum
	 */
	public Integer getHoleNum() {
		return holeNum;
	}
	/**
	 * @param holeNum the holeNum to set
	 */
	public void setHoleNum(Integer holeNum) {
		this.holeNum = holeNum;
	}
	/**
	 * @return the parRelative
	 */
	public String getParRelative() {
		return parRelative;
	}
	/**
	 * @param parRelative the parRelative to set
	 */
	public void setParRelative(String parRelative) {
		this.parRelative = parRelative;
	}
	/**
	 * @return the yardage
	 */
	public Integer getYardage() {
		return yardage;
	}
	/**
	 * @param yardage the yardage to set
	 */
	public void setYardage(Integer yardage) {
		this.yardage = yardage;
	}
	/**
	 * @return the strokes
	 */
	public Integer getStrokes() {
		return strokes;
	}
	/**
	 * @param strokes the strokes to set
	 */
	public void setStrokes(Integer strokes) {
		this.strokes = strokes;
	}
	/**
	 * @return the par
	 */
	public Integer getPar() {
		return par;
	}
	/**
	 * @param par the par to set
	 */
	public void setPar(Integer par) {
		this.par = par;
	}
	

}
