package com.cricket.CricketerApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/api")
public class PlayerController {

	@Autowired
	PlayerService service;
	
	@RequestMapping("/allplayer")
	public List<PlayerEntity> getAllPlayers(){
		return service.getAllPlayers();
	}
	
	//select player based on id
	@RequestMapping("/player/{id}")
	public PlayerEntity getPlayer(@PathVariable int id) {
		return service.getPlayer(id);
	}
	
//	//select player based on team
//	@RequestMapping(method = RequestMethod.GET,value="/player/{team}")
//	public PlayerEntity getPlayer(@PathVariable String team) {
//		 service.getPlayer(team);
//	}
	
    @RequestMapping(method = RequestMethod.GET,  value = "/player/{team}")
    public void getPlayerByEntity(@PathVariable String team){
    service.findPlayerByTeam(team);
    }
	
	//insert the player
	@RequestMapping(method = RequestMethod.POST,value="/player")
	public void addPlayer(@RequestBody PlayerEntity pl) {
		service.addPlayer(pl);
	}
	
	//update the player name style team matches and runs
	@RequestMapping(method=RequestMethod.PUT,value="/player/{id}")
	public void updatePlayer(@PathVariable int id,@RequestBody PlayerEntity p) {
		service.updatePlayer(id, p);
	}
	
	//delete the player
	@RequestMapping(method=RequestMethod.DELETE,value="/player/{id}")
	public void deletePlayer(@PathVariable int id) {
		service.deletePlayer(id);
	}
}
