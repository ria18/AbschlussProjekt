package com.tqg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tqg.dao.LizenzDAO;
import com.tqg.model.Lizenz;

@Service
@Transactional
public class LizenzServiceImpl implements LizenzService {

	@Autowired
	private LizenzDAO lizenzDAO;
	

	@Override
	public void addLizenz(Lizenz lizenz) {
		lizenzDAO.addLizenz(lizenz);
	}

	@Override
	public void deleteLizenz(Integer lizenzId) {
		lizenzDAO.deleteLizenz(lizenzId);
	}
	public Lizenz updateLizenz(Lizenz lizenz) {
		
		return lizenzDAO.updateLizenz(lizenz);
	}
	
	@Override
	public List<Lizenz> getAllLizenzs() {
		return lizenzDAO.getAllLizenzs();
	}


	public Lizenz getLizenzById(int id) {
		return lizenzDAO.getLizenzById(id);
	}






	
	

	
	
	
	



}
