package syndexmx.github.com.musicstruct.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import syndexmx.github.com.musicstruct.entities.ArtistEntity;

import java.util.UUID;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, UUID> {
}
