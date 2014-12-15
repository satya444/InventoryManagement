package com.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.dao.InventoryDAO;
import com.inventory.domain.Inventory;

@Service
public class InventoryService {

	@Autowired
	private InventoryDAO inventoryDAO;
	public List<Inventory> getAllListings() {
		// TODO Auto-generated method stub
		return inventoryDAO.getAllListings();
	}
	public void insertSong(Inventory song) {
		
		inventoryDAO.insert(song);
		
	}
	public Inventory getSong( int id) {
		return inventoryDAO.search(id);
	}
	public void edit( Inventory song) {
			inventoryDAO.editSave(song);
	}
	public void delete(int id){
			inventoryDAO.deleteSong(id);
	}
	public List<Inventory> search(int i, String songName) {
		return inventoryDAO.search(i,songName);
	}
	public List<Inventory> searchByid(Integer id) {
		
		return inventoryDAO.searchByid(id);
	}
}
