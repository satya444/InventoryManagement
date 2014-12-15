package com.inventory.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventory.domain.Inventory;

@Repository
public class InventoryDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Inventory> list() {
		Session session = this.sessionFactory.openSession();
		List<Inventory> personList = session.createQuery("from Inventory")
				.list();
		session.close();
		return personList;
	}

	public List<Inventory> getAllListings() {
		Session session = this.sessionFactory.openSession();
		List<Inventory> personList = session.createQuery("from Inventory")
				.list();
		session.close();
		return personList;
	}

	public void insert(Inventory song) {
		Session session = this.sessionFactory.openSession();
		session.save(song);

	}

	public Inventory search(int id) {
		Session session = this.sessionFactory.openSession();

		return (Inventory) session.load(Inventory.class, id);

	}

	public void editSave(Inventory song) {
		Session session = this.sessionFactory.openSession();
		System.out.println("UPDATING THIS VALUD" + song.getQuantityInStock());
		Query query = session
				.createQuery("update Inventory set songName = :songName , artistName = :artistName , albumName = :albumName, quantityInStock = :quantityInStock , unitPrice = :unitPrice , categoryName = :categoryName"
						+ " where id = :id");
		query.setParameter("songName", song.getSongName());
		query.setParameter("artistName", song.getArtistName());
		query.setParameter("albumName", song.getAlbumName());
		query.setParameter("quantityInStock", song.getQuantityInStock());
		query.setParameter("unitPrice", song.getUnitPrice());
		query.setParameter("categoryName", song.getCategoryName());
		query.setParameter("id", song.getId());
		query.executeUpdate();
		System.out.println("updated successfully");
	}

	public void deleteSong(int id) {
		Session session = this.sessionFactory.openSession();
		Query query= session.createQuery("delete Inventory where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	public List<Inventory> search(int i, String name) {
		Session session = this.sessionFactory.openSession();
		List<Inventory> list = null;
		if(i==1){
			Query query= session.createQuery("from Inventory where lower(songName) like lower(:songName) or lower(artistName) like lower(:artistName)");
			query.setParameter("songName","%"+ name+"%" );
			query.setParameter("artistName","%"+ name+"%");
			 list = query.list();
		}
		if(i==2){
			Query query= session.createQuery("from Inventory where lower(artistName) like lower(:artistName)");
			query.setParameter("artistName","%"+ name+"%");
			 list = query.list();
		}
		return list;
	}

	public List<Inventory> searchByid(Integer id) {
		Session session = this.sessionFactory.openSession();
		List<Inventory> list = null;
		Query query= session.createQuery("from Inventory where id= :id");
		query.setParameter("id", id );
		list=query.list();
		return list;
	}
}
