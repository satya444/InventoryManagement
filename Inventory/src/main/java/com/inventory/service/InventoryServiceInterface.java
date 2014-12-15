package com.inventory.service;

import java.util.List;

import com.inventory.domain.Inventory;

public interface InventoryServiceInterface {

	public List<Inventory> getAllListings();
	public void insertSong(Inventory song);
	public Inventory getSong(int id);
	public void edit(Inventory song);
	public void delete(int id);
	public List<Inventory> search(String songName);
}
