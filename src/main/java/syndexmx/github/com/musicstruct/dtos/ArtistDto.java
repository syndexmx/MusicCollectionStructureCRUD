package syndexmx.github.com.musicstruct.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ArtistDto {

    private String artistId;

    private String artistName;


}
