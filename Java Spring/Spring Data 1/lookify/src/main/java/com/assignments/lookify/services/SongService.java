package com.assignments.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assignments.lookify.models.Song;
import com.assignments.lookify.repositories.SongRepository;

@Service
public class SongService {

	private final SongRepository songRepository;

	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}

	public List<Song> allSongs() {
		return songRepository.findAll();
	}

	public Song createSong(Song song) {
		return songRepository.save(song);
	}

	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if (optionalSong.isPresent()) {
			return optionalSong.get();
		} else {
			return null;
		}
	}
	 public void deleteSong(Long id) {
	        songRepository.deleteById(id);
	    }
	 
	 public List<Song> artistSong(String artist) {
		 return songRepository.findByArtistContaining(artist);
	 }
	public List<Song> topTen(){
		return songRepository.findTop10ByOrderByRatingDesc();
	}
	

}
