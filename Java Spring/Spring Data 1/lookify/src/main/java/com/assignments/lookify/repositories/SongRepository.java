package com.assignments.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.assignments.lookify.models.Song;

public interface SongRepository extends CrudRepository<Song, Long> {

	List<Song> findAll();

	List<Song> findByArtistContaining(String search);
	
	List<Song> findTop10ByOrderByRatingDesc();;
}
