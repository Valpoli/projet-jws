# HardApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gamesGameIdPlayersPlayerIdBombPost**](HardApi.md#gamesGameIdPlayersPlayerIdBombPost) | **POST** /games/{gameId}/players/{playerId}/bomb | Put a bomb
[**gamesGameIdPlayersPlayerIdMovePost**](HardApi.md#gamesGameIdPlayersPlayerIdMovePost) | **POST** /games/{gameId}/players/{playerId}/move | Move a player


<a name="gamesGameIdPlayersPlayerIdBombPost"></a>
# **gamesGameIdPlayersPlayerIdBombPost**
> GameDetailResponse gamesGameIdPlayersPlayerIdBombPost(gameId, playerId, putBombRequest)

Put a bomb

Put a bomb at the specified coordinates

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.HardApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    HardApi apiInstance = new HardApi(defaultClient);
    Long gameId = 56L; // Long | 
    Long playerId = 56L; // Long | 
    PutBombRequest putBombRequest = new PutBombRequest(); // PutBombRequest | 
    try {
      GameDetailResponse result = apiInstance.gamesGameIdPlayersPlayerIdBombPost(gameId, playerId, putBombRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling HardApi#gamesGameIdPlayersPlayerIdBombPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gameId** | **Long**|  |
 **playerId** | **Long**|  |
 **putBombRequest** | [**PutBombRequest**](PutBombRequest.md)|  | [optional]

### Return type

[**GameDetailResponse**](GameDetailResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Bomb successfully placed |  -  |
**400** | The request is null, or the player name is null or the game cannot be started (already started, too many players), or not the same as the player |  -  |
**404** | The game with this ID, or the player does not exist |  -  |
**429** | The player has already put a bomb in the last X ticks |  -  |

<a name="gamesGameIdPlayersPlayerIdMovePost"></a>
# **gamesGameIdPlayersPlayerIdMovePost**
> GameDetailResponse gamesGameIdPlayersPlayerIdMovePost(gameId, playerId, movePlayerRequest)

Move a player

Move a player

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.HardApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    HardApi apiInstance = new HardApi(defaultClient);
    Long gameId = 56L; // Long | 
    Long playerId = 56L; // Long | 
    MovePlayerRequest movePlayerRequest = new MovePlayerRequest(); // MovePlayerRequest | 
    try {
      GameDetailResponse result = apiInstance.gamesGameIdPlayersPlayerIdMovePost(gameId, playerId, movePlayerRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling HardApi#gamesGameIdPlayersPlayerIdMovePost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gameId** | **Long**|  |
 **playerId** | **Long**|  |
 **movePlayerRequest** | [**MovePlayerRequest**](MovePlayerRequest.md)|  | [optional]

### Return type

[**GameDetailResponse**](GameDetailResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Player successfully moved |  -  |
**400** | The game is not running or the player is already dead. Or, the player cannot move to the specified position |  -  |
**404** | The game with this ID, or the player does not exist |  -  |
**429** | The player has already moved in the last X ticks |  -  |

