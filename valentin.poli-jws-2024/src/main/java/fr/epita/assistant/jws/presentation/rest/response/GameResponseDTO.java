package fr.epita.assistant.jws.presentation.rest.response;

import fr.epita.assistant.jws.data.model.PlayerModel;
import fr.epita.assistant.jws.utils.GameState;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

//@AllArgsConstructor @NoArgsConstructor
@Value @With
public class GameResponseDTO {
    Long id;
    GameState state;
    int playerCount;
}
