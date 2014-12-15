package com.inventory.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.annotations.CategoryType;
import com.inventory.annotations.TestThis;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 * 
 * @author pankaj
 *
 */
@Entity
@Table(name = "inventory")
public class Inventory implements Serializable{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty
	private String songName;
	@NotEmpty
	private String artistName;
	@NotEmpty
	private String albumName;
	@Min(value = 0)
	private int quantityInStock;
	@Min(value = 0)
	private double unitPrice;
	@NotEmpty
	@CategoryType
	private String categoryName;

	private double totalPrice;
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSongName() {
		return songName;
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getArtistName() {
		return artistName;
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getAlbumName() {
		return albumName;
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getCategoryName() {
		return categoryName;
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
