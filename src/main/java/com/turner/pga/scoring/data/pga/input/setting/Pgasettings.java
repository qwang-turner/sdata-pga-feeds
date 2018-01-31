package com.turner.pga.scoring.data.pga.input.setting;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;


@XmlRootElement(name="pga-settings")
@XmlType(name="pga-settings")
public class Pgasettings {

	@SerializedName("timezone") private String timezone; //5
	@SerializedName("location") private String location;
	@SerializedName("city") private String city;
	@SerializedName("state") private String state;


	
	@XmlElement(name="timezone")
	public String getTimezone(){
		return this.timezone;
	}

	 public void setTimezone(String timezone){
		this.timezone = timezone;
	}

	/**
	 * @return the location
	 */
	 @XmlElement(name="location")
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the city
	 */
	@XmlElement(name="city")
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	@XmlElement(name="state")
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}



}