package syndexmx.github.com.musicstruct.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import syndexmx.github.com.musicstruct.domain.Artist;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
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
