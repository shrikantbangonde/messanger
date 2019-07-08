package com.jarvis.RestDemo.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jarvis.RestDemo.model.Alien;
import com.jarvis.RestDemo.repository.AlienRepository;

@Path("aliens")
public class AlienResource {

	AlienRepository alienRepository = new AlienRepository();

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Alien> getAllAliens() {
		return alienRepository.getAliens();
	}

	@GET
	@Path("/{alienId}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Alien getAlien(@PathParam("alienId") int id) {
		
		return alienRepository.getAlien(id);
		}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("/{alienId}")
	public Alien createAlien(@PathParam("alienId") int id,Alien alien) {
		
		alienRepository.addAlien(alien);
		return alien;
	}
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("/{alienId}")
	public Alien updateAlien(@PathParam("alienId") int id,Alien alien) {
		   
		if(alienRepository.getAlien(alien.getId()).getId()==0){
			
			alienRepository.addAlien(alien);
			
			}
		    else {
		      alienRepository.update(alien);
            }
		return alien;
	}
	
	@DELETE
	@Path("/{alienId}")
	public Alien killAlien(@PathParam("alienId") int id) {
		
		Alien alien = alienRepository.getAlien(id);
		   
		if(alien.getId()!=0)
		alienRepository.delete(id);
		
		return alien;
		
	}
	
}
