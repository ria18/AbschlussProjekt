package com.tqg.dao;

import java.util.List;
import com.tqg.model.Lizenz;

public interface LizenzDAO {

	
	// testing singel Lizenz
	
	Lizenz get(int id);
	
	public Lizenz getLizenzById(int lizenzId);
	
	public List<Lizenz> getAllLizenzs();
	
	public void addLizenz(Lizenz lizenz);
	
	public void deleteLizenz(Integer lizenzId);
	
	public Lizenz updateLizenz(Lizenz lizenz);

	
	
	 

}
