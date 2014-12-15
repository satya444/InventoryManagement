package com.inventory.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventory.domain.Inventory;

@Repository
public class InventoryDAO implements InventoryDAOInterface{
	/**
	 * sessionFactory to perform transactions
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * runs HQL select
	 * 
	 * @return list of songs in inventory
	 */
	public List<Inventory> getAllListings() {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Inventory> inventoryList = session.createQuery("from Inventory")
				.list();
		session.close();
		return inventoryList;
	}

	/**
	 * runs HQL insert
	 * 
	 * @param song
	 *            input form service
	 */
	public void insert(Inventory song) throws HibernateException {
		Session session = this.sessionFactory.openSession();
		session.save(song);
	}

	/**
	 * runs HQL Select for id input
	 * 
	 * @param id
	 *            input from inventoryservice
	 * @return list of songs in inventory
	 */
	public Inventory search(int id) {
		Session session = this.sessionFactory.openSession();

		return (Inventory) session.load(Inventory.class, id);

	}

	/**
	 * runs HQL UPDATE
	 * 
	 * @param song
	 */
	public void editSave(Inventory song) throws HibernateException{
		Session session = this.sessionFactory.openSession();
		Query query = session
				.createQuery("update Inventory set songName = :songName , artistName = :artistName , albumName = :albumName, quantityInStock = :quantityInStock , unitPrice = :unitPrice , categoryName = :categoryName, totalPrice= :totalPrice"
						+ " where id = :id");
		query.setParameter("songName", song.getSongName());
		query.setParameter("artistName", song.getArtistName());
		query.setParameter("albumName", song.getAlbumName());
		query.setParameter("quantityInStock", song.getQuantityInStock());
		query.setParameter("unitPrice", song.getUnitPrice());
		query.setParameter("categoryName", song.getCategoryName());
		query.setParameter("totalPrice", song.getTotalPrice());
		query.setParameter("id", song.getId());
		query.executeUpdate();
		System.out.println("updated successfully");
	}

	/**
	 * runs HQL delete
	 * 
	 * @param id
	 */
	public void deleteSong(int id) {
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("delete Inventory where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	/**
	 * runs HQL select for given name
	 * 
	 * @param name
	 *            song or artist name from Inventoryservice
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Inventory> search(String name) {
		Session session = this.sessionFactory.openSession();
		List<Inventory> list = null;
		Query query = session
				.createQuery("from Inventory where lower(songName) like lower(:songName) or lower(artistName) like lower(:artistName)");
		query.setParameter("songName", "%" + name + "%");
		query.setParameter("artistName", "%" + name + "%");
		list = query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Inventory> searchByid(Integer id) {
		Session session = this.sessionFactory.openSession();
		List<Inventory> list = null;
		Query query = session.createQuery("from Inventory where id= :id");
		query.setParameter("id", id);
		list = query.list();
		return list;
	}
}
