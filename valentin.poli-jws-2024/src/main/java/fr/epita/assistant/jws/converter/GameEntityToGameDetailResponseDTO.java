package fr.epita.assistant.jws.converter;

import fr.epita.assistant.jws.domain.entity.GameEntity;
import fr.epita.assistant.jws.domain.entity.PlayerEntity;
import fr.epita.assistant.jws.presentation.rest.response.GameDetailResponseDTO;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ApplicationScoped
public class GameEntityToGameDetailResponseDTO {
    public GameDetailResponseDTO convert(GameEntity entity)
    {
        return new GameDetailResponseDTO(
                entity.id,
                entity.starttime,
                entity.state,
                entity.players.stream().map(this::convertPlayer).collect(Collectors.toList()),
                entity.map
        );
    }

    public GameDetailResponseDTO.Player convertPlayer(PlayerEntity player)
    {
        return new GameDetailResponseDTO.Player(
                player.id,
                //player.lastbomb,
                //player.lastmovement,
                player.lives,
                player.name,
                player.posX,
                player.posY
                //player.position
        );
    }

}
