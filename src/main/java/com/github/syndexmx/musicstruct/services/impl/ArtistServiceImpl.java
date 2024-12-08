package com.github.syndexmx.musicstruct.services.impl;

import com.github.syndexmx.musicstruct.domain.Artist;
import com.github.syndexmx.musicstruct.entities.ArtistEntity;
import com.github.syndexmx.musicstruct.repositories.ArtistRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.github.syndexmx.musicstruct.services.ArtistService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    @Autowired
    private ArtistServiceImpl(ArtistRepository artistRepository) {

        this.artistRepository = artistRepository;
    }

    @Override
    public Artist create(Artist artist) {
        String spoofId;
        do {
            spoofId = UUID.randomUUID().toString();
        } while (artistRepository.existsById(UUID.fromString(spoofId)));
        artist.setArtistId(spoofId);
        final ArtistEntity savedEntity = artistRepository.save(ArtistEntity.artistToArtistEntity(artist));
        final Artist savedArtist = ArtistEntity.artistEntityToArtist(savedEntity);
        return savedArtist;
    }

    @Override
    public Artist save(Artist artist) {
        final ArtistEntity savedEntity = artistRepository.save(ArtistEntity.artistToArtistEntity(artist));
        final Artist savedArtist = ArtistEntity.artistEntityToArtist(savedEntity);
        return savedArtist;
    }

    @Override
    public Optional<Artist> findById(String artistId) {
        final Optional<ArtistEntity> artistEntityFound = artistRepository
                .findById(UUID.fromString(artistId));
        final Optional<Artist> artistFound = artistEntityFound.map(artistEntity ->
                ArtistEntity.artistEntityToArtist(artistEntity));
        return artistFound;
    }

    @Override
    public List<Artist> listArtist() {
        final List<ArtistEntity> listOfFoundArtistEntities = artistRepository.findAll();
        final List<Artist> listOfFoundArtist =listOfFoundArtistEntities.stream()
                .map(entity -> ArtistEntity.artistEntityToArtist(entity)).toList();
        return listOfFoundArtist;
    }

    @Override
    public boolean isPresent(String artistId) {

        return artistRepository.existsById(UUID.fromString(artistId));
    }

    @Override
    public boolean isPresent(Artist artist) {
        return artistRepository.existsById(UUID.fromString(artist.getArtistId()));
    }

    @Override
    public void deleteArtistById(String artistId) {
        try {
            artistRepository.deleteById(UUID.fromString(artistId));
        } catch (final EmptyResultDataAccessException e) {
            log.debug("Attempted to delete non-existent Artist");
        }
    }

}
