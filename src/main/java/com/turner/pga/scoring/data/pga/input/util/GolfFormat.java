package com.turner.pga.scoring.data.pga.input.util;

public class GolfFormat {

	public static String formatScore(Integer score) {
		String strScore;
		if(score == null){
			strScore = "";
		}else if(score == 0){
			strScore = "E";
		}else{
			strScore = String.format("%+d", score);
		}
		
		return strScore;
	}

	public static String formatThru(Integer thru) {

		String strThru;
		if(thru == null){
			strThru = "";
		}else if(thru == 18){
			strThru = "F";
		}else if(thru == 0){
			strThru = "";
		}else{
			strThru = String.format("%d", thru);
		}
		
		return strThru;
	}
	
	public static Integer convertZeroAsNull(Integer value){
		return (value == null || value == 0)?null:value;
	}

}
