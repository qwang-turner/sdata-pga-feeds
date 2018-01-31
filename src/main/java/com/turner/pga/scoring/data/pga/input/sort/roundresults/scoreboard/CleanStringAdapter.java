package com.turner.pga.scoring.data.pga.input.sort.roundresults.scoreboard;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CleanStringAdapter extends XmlAdapter<String, String>  {

	@Override
	public String unmarshal(String v) throws Exception {
		return v.trim();
	}

	@Override
	public String marshal(String v) throws Exception {
		return v.trim();
	}

}
