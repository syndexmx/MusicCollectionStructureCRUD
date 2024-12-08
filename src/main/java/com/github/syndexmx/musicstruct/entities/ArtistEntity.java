package com.github.syndexmx.musicstruct.entities;


import com.github.syndexmx.musicstruct.domain.Artist;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "artists")
public class ArtistEntity {

    @Id
    @Column(name = "artist_id")
    private UUID artistId;

    @Column(name = "artist_name")
    private String artistName;

    public static ArtistEntity artistToArtistEntity(Artist artist) {
        final ArtistEntity artistEntity = ArtistEntity.builder()
                .artistId(UUID.fromString(artist.getArtistId()))
                .artistName(artist.getArtistName())
                .build();
        return artistEntity;
    }

    public static Artist artistEntityToArtist(ArtistEntity artistEntity) {
        Artist artist = Artist.builder()
                .artistId(artistEntity.getArtistId().toString())
                .artistName(artistEntity.getArtistName())
                .build();
        return artist;

    }

}
