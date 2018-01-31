package com.turner.pga.scoring.data.pga.input.score.golfscores.rounds.round;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class PGATeeTimeAdapter extends XmlAdapter<String, Calendar> {

	private static final String FORMAT = "h:mm";
	private static DateFormat df = new SimpleDateFormat(FORMAT);

	@Override
	public Calendar unmarshal(String v) throws Exception {
		Calendar cal = null;
		if (v != null && v.length() > 0) {
			Date date = df.parse(v);
			cal = Calendar.getInstance();
			cal.setTime(date);
		}

		return cal;
	}

	@Override
	public String marshal(Calendar v) throws Exception {
		String calStr = "";
		if (v != null) {
			calStr = df.format(v);
		}
		return calStr;
	}

}
