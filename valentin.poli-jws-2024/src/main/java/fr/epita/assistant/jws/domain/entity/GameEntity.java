package fr.epita.assistant.jws.domain.entity;

import fr.epita.assistant.jws.data.model.PlayerModel;
import fr.epita.assistant.jws.utils.GameState;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor @NoArgsConstructor
public class GameEntity {
    public Long id;
    public LocalDateTime starttime;
    public GameState state;
    public List<PlayerEntity> players;
    public List<String> map;
}
