package syndexmx.github.com.musicstruct.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import syndexmx.github.com.musicstruct.domain.Artist;
import syndexmx.github.com.musicstruct.dtos.ArtistDto;
import syndexmx.github.com.musicstruct.services.ArtistService;

import java.util.List;
import java.util.Optional;

import static syndexmx.github.com.musicstruct.dtos.ArtistDtoMapper.artistDtoToArtist;
import static syndexmx.github.com.musicstruct.dtos.ArtistDtoMapper.artistToArtistDto;


@RestController
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    private ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping("/api/v0/artists")
    public ResponseEntity<ArtistDto> createEntity(@RequestBody final ArtistDto artistDto) {
        final Artist artist = artistDtoToArtist(artistDto);
        final ResponseEntity<ArtistDto> responseEntity = new ResponseEntity<> (
                artistToArtistDto(artistService.create(artist)), HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/api/v0/artists/{artistId}")
    public ResponseEntity<ArtistDto> retrieveArtist(@PathVariable String artistId) {
        final Optional<Artist> foundArtist = artistService.findById(artistId);
        if (foundArtist.isEmpty()) {
            return new ResponseEntity<ArtistDto>(HttpStatus.NOT_FOUND);
        } else {
            final ArtistDto artistDto = artistToArtistDto(foundArtist.get());
            return new ResponseEntity<ArtistDto>(artistDto, HttpStatus.FOUND);
        }
    }

    @GetMapping("/api/v0/artists")
    public ResponseEntity<List<ArtistDto>> retrieveAllArtists() {
        final List<Artist> listFoundArtists = artistService.listArtist();
        final List<ArtistDto> listFoundArtistDtos = listFoundArtists.stream()
                .map(artist -> artistToArtistDto(artist)).toList();
        final ResponseEntity<List<ArtistDto>> response = new ResponseEntity<>(listFoundArtistDtos,
                HttpStatus.OK);
        return response;
    }

    @PutMapping("/api/v0/artists")
    public ResponseEntity<ArtistDto> updateEntity(@RequestBody final ArtistDto artistDto) {
        final Artist artist = artistDtoToArtist(artistDto);
        if (!artistService.isPresent(artist)) {
            final ResponseEntity<ArtistDto> responseEntity = new ResponseEntity<> (
                    artistToArtistDto(artistService.save(artist)), HttpStatus.CREATED);
            return responseEntity;
        }
        final ResponseEntity<ArtistDto> responseEntity = new ResponseEntity<> (
                artistToArtistDto(artistService.save(artist)), HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/api/v0/artist/{artistId}")
    public ResponseEntity deleteArtistById(@PathVariable String artistId) {
        artistService.deleteArtistById(artistId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
