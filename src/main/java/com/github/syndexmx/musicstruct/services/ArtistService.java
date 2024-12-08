package com.github.syndexmx.musicstruct.services;


import com.github.syndexmx.musicstruct.domain.Artist;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ArtistService {

    Artist create(Artist artist);

    Artist save(Artist artist);

    Optional<Artist> findById(String artistId);

    List<Artist> listArtist();

    boolean isPresent(String artistId);

    boolean isPresent(Artist artist);

    void deleteArtistById(String artistId);

}
