package fr.epita.assistant.jws.domain.entity;

import fr.epita.assistant.jws.data.model.GameModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@AllArgsConstructor @NoArgsConstructor
public class PlayerEntity {
    public Long id;
    public LocalDateTime lastbomb;
    public LocalDateTime lastmovement;
    public int lives;
    public String name;
    public int posX;
    public int posY;
    public int position;
}
