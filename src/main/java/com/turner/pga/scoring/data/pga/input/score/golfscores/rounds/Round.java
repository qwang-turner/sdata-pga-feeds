package com.turner.pga.scoring.data.pga.input.score.golfscores.rounds;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.google.gson.annotations.SerializedName;
import com.turner.pga.scoring.data.pga.input.course.PgaGolfcourses;
import com.turner.pga.scoring.data.pga.input.score.golfscores.rounds.round.Group;
import com.turner.pga.scoring.data.pga.input.score.golfscores.rounds.round.group.ScorePlayer;


@XmlRootElement(name="Round")
@XmlType(name="Round",namespace="/GolfScores/Rounds")
public class Round {

	@SerializedName("ID") private Integer ID; //1
	@SerializedName("MaxHoles") private Integer MaxHoles; //18
	@SerializedName("Group") private List<Group> GroupList = new ArrayList<Group>();

	private Map<String,ScorePlayer> playerMap = new HashMap<String,ScorePlayer>();
	private Map<String,Group> groupMap = new HashMap<String,Group>();
	private Map<String,List<Group>> crsGroupsMap = new HashMap<String, List<Group>>();

	
	@XmlAttribute(name="ID")
	public Integer getID(){
		return this.ID;
	}

	 public void setID(Integer ID){
		this.ID = ID;
	}

	
	@XmlAttribute(name="MaxHoles")
	public Integer getMaxHoles(){
		return this.MaxHoles;
	}

	 public void setMaxHoles(Integer MaxHoles){
		this.MaxHoles = MaxHoles;
	}

	
	@XmlElement(name="Group")
	public List<Group> getGroupList(){
		return this.GroupList;
	}

	 public void setGroupList(List<Group> GroupList){
		this.GroupList = GroupList;
	}

	public ScorePlayer findPlayer(String playerId) {
		return playerMap.get(playerId);
	}

	public Group findGroup(String playerid) {
		return groupMap.get(playerid);
	}

	public void prepareData(PgaGolfcourses pgaCourses) {
		if(playerMap.size() == 0){
			for (Group group : GroupList) {
				List<Group> crsGroupList = crsGroupsMap.get(group.getCourse());
				if(crsGroupList == null){
					crsGroupList = new ArrayList<Group>();
					crsGroupsMap.put(group.getCourse(), crsGroupList);
				}
				
				crsGroupList.add(group);
				
				for (ScorePlayer plr : group.getPlayerList()) {
					plr.prepareData(pgaCourses.findCourse(group.getCourse()));
					plr.setRnd(this.ID);
					plr.setTTime(group.getTTime());
					plr.setStart(group.getStart());
					playerMap.put(plr.getPGAHQID(), plr);
					groupMap.put(plr.getPGAHQID(), group);
					
					
				}
			}
		}
	}

	public List<Group> findGroups(String crsId) {
		return crsGroupsMap.get(crsId);
	}

}