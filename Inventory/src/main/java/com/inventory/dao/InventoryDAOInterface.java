package com.inventory.dao;

import java.util.List;

import com.inventory.domain.Inventory;

public interface InventoryDAOInterface {
	public List<Inventory> getAllListings();
	public void insert(Inventory song);
	public Inventory search(int id);
	public void editSave(Inventory song);
	public void deleteSong(int id);
	public List<Inventory> search(String name);
	public List<Inventory> searchByid(Integer id) ;

	
}
