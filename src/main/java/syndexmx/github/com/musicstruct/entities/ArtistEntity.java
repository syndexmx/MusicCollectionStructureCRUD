package syndexmx.github.com.musicstruct.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import syndexmx.github.com.musicstruct.domain.Artist;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "artists_table")
public class ArtistEntity {

    @Id
    @Column(name = "artist_id")
    private UUID artistId;

    @Column(name = "artist_string")
    private String artistString;

    public static ArtistEntity artistToArtistEntity(Artist artist) {
        final ArtistEntity artistEntity = ArtistEntity.builder()
                .artistId(UUID.fromString(artist.getArtistId()))
                .artistString(artist.getArtistName())
                .build();
        return artistEntity;
    }

    public static Artist artistEntityToArtist(ArtistEntity artistEntity) {
        Artist artist = Artist.builder()
                .artistId(artistEntity.getArtistId().toString())
                .artistName(artistEntity.getArtistString())
                .build();
        return artist;

    }

}
