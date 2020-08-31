package com.tqg.service;

import java.util.List;
import com.tqg.model.Lizenz;

public interface LizenzService {
	
	/*
	 * CRUD Operation Service   
	 */
	
	
	public void addLizenz(Lizenz lizenz);
	
	public void deleteLizenz(Integer lizenzId);
	
	public Lizenz updateLizenz(Lizenz lizenz);

	public Lizenz getLizenzById(int lizenzId);
	
	public List<Lizenz> getAllLizenzs();


	
	

}
