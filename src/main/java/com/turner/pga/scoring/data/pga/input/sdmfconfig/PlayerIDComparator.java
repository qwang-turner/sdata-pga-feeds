package com.turner.pga.scoring.data.pga.input.sdmfconfig;

import java.util.Comparator;

import com.turner.pga.scoring.data.pga.input.sdmfconfig.tournament.players.Player;

public class PlayerIDComparator implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		return o1.getPLAYERId().compareTo(o2.getPLAYERId());
	}

}
