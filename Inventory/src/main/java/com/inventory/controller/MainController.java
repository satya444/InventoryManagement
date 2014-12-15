package com.inventory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.inventory.domain.Inventory;
import com.inventory.service.InventoryService;

@Controller
public class MainController {

	/**
	 * Reference to InventoryService
	 */
	@Autowired
	private InventoryService inventoryService;

	/**
	 * get all the songs from inventory
	 * 
	 * @param model
	 * @return listings page
	 */
	@RequestMapping(value = { "/listings", "/" }, method = RequestMethod.GET)
	public String getdata(Model model) {

		model.addAttribute("listings", new Inventory());

		model.addAttribute("lists", this.inventoryService.getAllListings());
		return "listings";

	}

	/**
	 * Save and edit a song to Inventory
	 * 
	 * @param song
	 * @param br
	 * @param model
	 * @return listings page
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveInsert(@Valid @ModelAttribute("listings") Inventory song,
			BindingResult br, Model model) {
		if (br.hasErrors()) {
			model.addAttribute("lists", this.inventoryService.getAllListings());

			return "listings";
		}
		song.setTotalPrice(song.getQuantityInStock() * song.getUnitPrice());
		if (song.getId() == null) {
			inventoryService.insertSong(song);
		} else {
			inventoryService.edit(song);
		}
		return "redirect:/listings";
	}

	/**
	 * Edit based on Id of song
	 * 
	 * @param id
	 *            - input Id from jsp
	 * @param model
	 * @return listings page
	 */
	@RequestMapping(value = "/edit/{id}")
	public String saveEdit(@PathVariable Integer id, Model model) {
		model.addAttribute("listings", this.inventoryService.getSong(id));
		model.addAttribute("lists", this.inventoryService.getAllListings());
		return "listings";
	}

	/**
	 * Remove the song with requested id
	 * 
	 * @param id
	 *            - id from jsp to controller
	 * @return to listings
	 */

	@RequestMapping(value = "/remove/{id}")
	public String remove(@PathVariable Integer id) {
		this.inventoryService.delete(id);
		return "redirect:/listings";
	}

	/**
	 * search for song by song or ArtistName
	 * 
	 * @param model
	 * @param songName
	 *            - name from jsp. Looks for both song and Artist Name
	 * @return to the page containing search results
	 */
	@RequestMapping(value = "/searchBySongOrArtistName", method = RequestMethod.POST)
	public String searchBySongName(Model model,
			@RequestParam("songName") String songName) {

		model.addAttribute("listings", new Inventory());
		List<Inventory> list = this.inventoryService.search(songName);
		model.addAttribute("searchBySongOrArtistName", new Inventory());
		model.addAttribute("lists", list);
		return "/searchBySongOrArtistName";
	}

}