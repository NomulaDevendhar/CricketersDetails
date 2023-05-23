package com.cricket.CricketerApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


@Service
public class PlayerService {

	@Autowired
	private PlayerRepository repository;
	
	//insert the player
	public void addPlayer(PlayerEntity p) {
		repository.save(p);
	}
	
	//select all players 
	public List<PlayerEntity> getAllPlayers(){
		return repository.findAll();
	}
	
	//select player based on id
	public PlayerEntity getPlayer(int id) {
		return repository.findById(id).get();
	}
	
//	//select player based on team
//	public PlayerEntity getPlayer(String team) {
//		return repository.findByTeam(team).get();
//	}
	
	
	//update the player name team matches runs 
	public void updatePlayer(int id,PlayerEntity newEntitySet) {
		if(repository.findById(id).isPresent()==true) {
			PlayerEntity oldEntitySet = repository.findById(id).get();
			oldEntitySet.setName(newEntitySet.getName());
			oldEntitySet.setTeam(newEntitySet.getTeam());
			oldEntitySet.setBstyle(newEntitySet.getBstyle());
			oldEntitySet.setMatches(newEntitySet.getMatches());
			oldEntitySet.setRuns(newEntitySet.getRuns());
			repository.save(oldEntitySet);
		}
	}
	
	//delete the player
	public void deletePlayer(int id) {
		repository.deleteById(id);
	}
	
    @Query("Select player from PlayerEntity where player.team=:team")
    public PlayerEntity findPlayerByTeam(@Param("team") String team){
       return new PlayerEntity();
   }
}
