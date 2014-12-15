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

	@Autowired
	private InventoryService inventoryService;

	@RequestMapping(value = {"/listings","/"}, method = RequestMethod.GET)
	public String getdata(Model model) {

		model.addAttribute("listings", new Inventory());
		
		model.addAttribute("lists", this.inventoryService.getAllListings());
		return "listings";

	}




	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveInsert(@Valid @ModelAttribute("listings") Inventory song, BindingResult br,Model model){
		if(br.hasErrors()){
			model.addAttribute("lists", this.inventoryService.getAllListings());
			
			return "listings";
		}
		song.setTotalPrice(song.getQuantityInStock()*song.getUnitPrice());
		if(song.getId()==null ){

		inventoryService.insertSong(song);
		}
		else{
			inventoryService.edit(song);
		}
		
		return "redirect:/listings";
	}

	@RequestMapping(value = "/edit/{id}")
	public String saveEdit(@PathVariable Integer id, Model model) {
		  model.addAttribute("listings", this.inventoryService.getSong(id));
	        model.addAttribute("lists", this.inventoryService.getAllListings());
	        return "listings";
	}
	
	@RequestMapping(value = "/remove/{id}")
	public String remove(@PathVariable Integer id) {
		this.inventoryService.delete(id);
        return "redirect:/listings";
	}


	@RequestMapping(value = "/searchBySongName", method = RequestMethod.POST)
	public String searchBySongName(Model model,@RequestParam("songName") String songName){
		System.out.println("songName is---- "+songName);
		
		
		model.addAttribute("listings", new Inventory());
		List<Inventory> list= this.inventoryService.search(1, songName);
		model.addAttribute("searchBySongName", new Inventory());
		model.addAttribute("lists", list);
		return "/searchBySongName";
	}

	
	@RequestMapping(value = "/searchByArtistName", method = RequestMethod.POST)
	public String searchByArtistName(Model model,@RequestParam("artistName") String artistName){
	System.out.println("songName is---- "+artistName);
		model.addAttribute("listings", new Inventory());
		List<Inventory> list= this.inventoryService.search(2, artistName);
		model.addAttribute("searchBySongName", new Inventory());
		model.addAttribute("lists", list);
	return "/searchByArtistName";
	}


}