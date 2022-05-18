package fr.epita.assistant.jws.domain.service;

import javax.inject.Inject;
import fr.epita.assistant.jws.converter.GameModelToGameEntityConverter;
import fr.epita.assistant.jws.data.model.GameModel;
import fr.epita.assistant.jws.data.model.PlayerModel;
import fr.epita.assistant.jws.data.repository.GameRepository;
import fr.epita.assistant.jws.data.repository.PlayerRepository;
import fr.epita.assistant.jws.domain.entity.GameEntity;
import fr.epita.assistant.jws.utils.GameState;
import org.eclipse.microprofile.config.inject.ConfigProperties;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class GameService {
    @Inject GameRepository gameRepository;
    @Inject GameModelToGameEntityConverter gameModelToGameEntityConverter;
    @Inject PlayerRepository playerRepository;
    @ConfigProperties

    @Transactional
    public List<GameEntity> getAll()
    {
        var games = gameRepository.findAll();
        return games.stream().map(game -> gameModelToGameEntityConverter.convert(game)).collect(Collectors.toList());
    }

    @Transactional
    public GameEntity createGame(String name) throws IOException {
        Path map = Paths.get("/home/epita/JWS/valentin.poli-jws-2024/src/test/resources/map1.rle");
        List<String> map_l = Files.readAllLines(map);
        var gameModel = new GameModel().withStarttime(LocalDateTime.now()).withState(GameState.STARTING)
                .withPlayers(new ArrayList<PlayerModel>(Collections.singleton(new PlayerModel().withName(name).withPosX(1).withPosY(1).withLives(3)))).withMap(map_l);
        gameRepository.persist(gameModel);
        return gameModelToGameEntityConverter.convert(gameModel);
    }

    @Transactional
    public GameEntity getById(long id) {
        var model = gameRepository.findById(id);
        if (model == null)
        {
            return null;
        }
        return gameModelToGameEntityConverter.convert(model);
    }

    @Transactional
    public GameEntity addPlayerToGame(Long id, String playerName)
    {
        List<List<Integer>> list = new ArrayList<>();
        var model = gameRepository.findById(id);
        if (model == null)
        {
            return null;
        }
        var playerModel = new PlayerModel()
                .withName(playerName).withLives(3).withPosX(1).withPosY(1).withGame(model);
        playerRepository.persist((playerModel));
        model.players.add(playerModel);
        return gameModelToGameEntityConverter.convert(model);
    }

    @Transactional
    public GameEntity RunGame(long id)
    {
        var model = gameRepository.findById(id);
        if (model == null)
        {
            return null;
        }
        model.state = GameState.RUNNING;
        return gameModelToGameEntityConverter.convert(model);
    }
}
