package com.assignments.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignments.lookify.models.Song;
import com.assignments.lookify.services.SongService;

@Controller
public class SongsController {

	private final SongService songService;

	public SongsController(SongService songService) {
		this.songService = songService;
	}

	@RequestMapping("/")
	public String index() {
		return "/songs/index.jsp";
	}

	@RequestMapping("/dashboard")
	public String index(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "/songs/dashboard.jsp";
	}

	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "/songs/new.jsp";
	}

	@RequestMapping(value = "/songs/new", method = RequestMethod.POST)
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "/songs/new.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/songs/" + song.getId();
		}
	}

	@RequestMapping("/songs/{id}")
	public String showSong(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return ("/songs/show.jsp");
	}

	@RequestMapping(value = "/songs/delete/{id}", method = RequestMethod.GET)
	public String destroy(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@RequestParam("search") String search) {
		return "redirect:/search/" + search;
	}

	@RequestMapping(value="/search/{search}", method=RequestMethod.GET)
	public String findbyArtist(@PathVariable("search") String search,Model model) {
		List<Song> songs=songService.artistSong(search);
		model.addAttribute("songs",songs);
		model.addAttribute("search",search);
		return "songs/artist.jsp";
	}
	
	@RequestMapping("/search/topTen")
	public String findTopTen(Model model) {
		List<Song> songs=songService.topTen();
		model.addAttribute("songs", songs);
		return "songs/topten.jsp";
	}
}
