package syndexmx.github.com.musicstruct.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import syndexmx.github.com.musicstruct.domain.Artist;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ArtistDto {

    private String artistId;

    private String artistString;


}
