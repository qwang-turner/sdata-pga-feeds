package com.turner.pga.scoring.data.pga.input.sort.roundresults;

import java.util.Comparator;

import com.turner.pga.scoring.data.pga.input.sort.roundresults.scoreboard.SortPlayer;

public class PgaReviousRoundComparator implements Comparator<SortPlayer> {

	@Override
	public int compare(SortPlayer p1, SortPlayer p2) {
		int comp = p2.getLastCompleteRound().compareTo(p1.getLastCompleteRound());
		if(comp == 0){
			comp = p1.getPreviousStrokes().compareTo(p2.getPreviousStrokes());
		}
		
		return comp;
	}


}
