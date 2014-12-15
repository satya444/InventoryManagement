package com.inventory.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.dao.InventoryDAO;
import com.inventory.domain.Inventory;

@Service
public class InventoryService {

	/**
	 * reference to InventoryDAO
	 */
	@Autowired
	private InventoryDAO inventoryDAO;

	/**
	 * obtains list of songs in inventory
	 * 
	 * @return list of songs
	 */
	public List<Inventory> getAllListings() {
		// TODO Auto-generated method stub
		return inventoryDAO.getAllListings();
	}

	/**
	 * adds the song to inventory
	 * 
	 * @param song
	 */
	public void insertSong(Inventory song) throws HibernateException{
		inventoryDAO.insert(song);
	}

	/**
	 * returns the song with particular id
	 * 
	 * @param id
	 *            - from search
	 * @return Inventory object
	 */
	public Inventory getSong(int id) {
		return inventoryDAO.search(id);
	}

	/**
	 * to edit a song
	 * 
	 * @param song
	 */
	public void edit(Inventory song) throws HibernateException{
		inventoryDAO.editSave(song);
	}

	/**
	 * delete a song
	 * 
	 * @param id
	 *            input form MainController
	 */
	public void delete(int id) {
		inventoryDAO.deleteSong(id);
	}

	/**
	 * search a given songName
	 * 
	 * @param songName
	 *            name from controller
	 * @return
	 */
	public List<Inventory> search(String songName) {
		return inventoryDAO.search(songName);
	}
}
