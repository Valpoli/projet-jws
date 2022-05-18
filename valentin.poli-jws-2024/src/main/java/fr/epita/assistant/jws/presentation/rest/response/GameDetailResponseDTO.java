package fr.epita.assistant.jws.presentation.rest.response;

import fr.epita.assistant.jws.domain.entity.PlayerEntity;
import fr.epita.assistant.jws.utils.GameState;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
public class GameDetailResponseDTO {
    public Long id;
    public LocalDateTime starttime;
    public GameState state;
    public List<Player> players;
    public List<String> map;

    @AllArgsConstructor @NoArgsConstructor
    public static class Player
    {
        public Long id;
        /*public LocalDateTime lastbomb;
        public LocalDateTime lastmovement;*/
        public int lives;
        public String name;
        public int posx;
        public int posy;
        //public int position;
    }
}
