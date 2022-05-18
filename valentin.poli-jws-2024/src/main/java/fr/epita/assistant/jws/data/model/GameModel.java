package fr.epita.assistant.jws.data.model;

import fr.epita.assistant.jws.utils.GameState;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Table(name = "game")
@AllArgsConstructor @NoArgsConstructor @With @ToString
public class GameModel {
    public @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    public LocalDateTime starttime;
    public GameState state;
    public @OneToMany(cascade = CascadeType.ALL) List<PlayerModel> players;
    public @ElementCollection @CollectionTable(name="game_map") List<String> map;
}
