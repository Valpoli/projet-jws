package fr.epita.assistant.jws.converter;

import fr.epita.assistant.jws.data.model.GameModel;
import fr.epita.assistant.jws.data.model.PlayerModel;
import fr.epita.assistant.jws.domain.entity.GameEntity;
import fr.epita.assistant.jws.domain.entity.PlayerEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.stream.Collectors;

@ApplicationScoped
public class GameModelToGameEntityConverter {
    public GameEntity convert(GameModel model){
        return new GameEntity(
                model.id,
                model.starttime,
                model.state,
                model.players.stream().map(player -> convertPlayer(player)).collect(Collectors.toList()),
                model.map
        );
    }

        public PlayerEntity convertPlayer(PlayerModel player)
        {
            return new PlayerEntity(
                    player.id,
                    player.lastbomb,
                    player.lastmovement,
                    player.lives,
                    player.name,
                    player.posX,
                    player.posY,
                    player.position
            );

        }
}
