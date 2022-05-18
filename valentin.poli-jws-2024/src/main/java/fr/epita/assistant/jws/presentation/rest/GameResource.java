package fr.epita.assistant.jws.presentation.rest;

import fr.epita.assistant.jws.converter.GameEntityToGameDetailResponseDTO;
import fr.epita.assistant.jws.domain.entity.GameEntity;
import fr.epita.assistant.jws.domain.service.GameService;
import fr.epita.assistant.jws.presentation.rest.request.AddPlayerRequestDTO;
import fr.epita.assistant.jws.presentation.rest.request.CreateGameRequestDTO;
import fr.epita.assistant.jws.presentation.rest.response.GameResponseDTO;
import fr.epita.assistant.jws.utils.GameState;
import org.jboss.resteasy.plugins.providers.ReaderProvider;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GameResource {
    @Inject GameService gameService;
    @Inject GameEntityToGameDetailResponseDTO gameEntityToGameDetailResponseDTO;
    @GET @Path("games")
    public List<GameResponseDTO> getAll() {
        var games = gameService.getAll();
        return games.stream().map(game -> new GameResponseDTO(game.id,game.state,game.players.size())).collect(Collectors.toList());
    }

    @POST @Path("games")
    public Response create(CreateGameRequestDTO request) throws IOException {
        if (request == null || request.name == null)
        {
            return Response.status(400).build();
        }
        var gameEntity = gameService.createGame(request.name);
        return Response.ok(gameEntity).build();
    }

    @GET @Path("games/{gameid}")
    public Response getById(@PathParam("gameid") Long id)
    {
        if (id == null)
        {
            return Response.status(400).build();
        }
        var GameEntity = gameService.getById(id);
        if (GameEntity == null)
        {
            return Response.status(404).build();
        }
        return Response.ok(gameEntityToGameDetailResponseDTO.convert(GameEntity)).build();
    }

    @POST @Path("games/{gameid}")
    public Response addPlayer(@PathParam("gameid") Long id, AddPlayerRequestDTO request)
    {
        if (request != null && request.name != null && id != null)
        {
            return Response.status(400).build();
        }
        var entity = gameService.addPlayerToGame(id, request.name);
        if (entity == null)
        {
            return Response.status(404).build();
        }
        if (entity.state.equals(GameState.STARTING) || entity.players.size() == 4)
        {
            return Response.status(400).build();
        }
        return Response.ok(gameEntityToGameDetailResponseDTO.convert(entity)).build();
    }

    @PATCH @Path("games/{gameid}/start")
    public Response StartingGame(@PathParam("gameid") Long id)
    {
        if (id == null)
        {
            return Response.status(404).build();
        }
        var entity = gameService.RunGame(id);
        if (entity == null)
        {
            return Response.status(404).build();
        }
        return Response.ok(gameEntityToGameDetailResponseDTO.convert(entity)).build();
    }
}