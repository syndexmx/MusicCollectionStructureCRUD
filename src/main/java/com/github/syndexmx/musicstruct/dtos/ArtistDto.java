package com.github.syndexmx.musicstruct.dtos;


import com.github.syndexmx.musicstruct.domain.Artist;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ArtistDto {

    private String artistId;

    private String artistName;

    public static ArtistDto artistToArtistDto(Artist artist) {
        return ArtistDto.builder()
                .artistId(artist.getArtistId())
                .artistName(artist.getArtistName())
                .build();
    }

    public static Artist artistDtoToArtist(ArtistDto artistDto) {
        return Artist.builder()
                .artistId(artistDto.getArtistId())
                .artistName(artistDto.getArtistName())
                .build();
    }

}
