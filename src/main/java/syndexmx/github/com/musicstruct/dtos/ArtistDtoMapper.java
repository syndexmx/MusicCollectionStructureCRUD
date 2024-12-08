package syndexmx.github.com.musicstruct.dtos;

import syndexmx.github.com.musicstruct.domain.Artist;

public class ArtistDtoMapper {
    public static ArtistDto artistToArtistDto(Artist artist) {
        final ArtistDto artistDto = ArtistDto.builder()
                .artistId(artist.getArtistId())
                .artistString(artist.getArtistString())
                .build();
        return artistDto;
    }

    public static Artist artistDtoToArtist(ArtistDto artistDto) {
        Artist artist = Artist.builder()
                .artistId(artistDto.getArtistId())
                .artistString(artistDto.getArtistString())
                .build();
        return artist;
    }
}
