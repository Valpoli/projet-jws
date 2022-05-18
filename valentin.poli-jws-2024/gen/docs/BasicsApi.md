# BasicsApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gamesGameIdGet**](BasicsApi.md#gamesGameIdGet) | **GET** /games/{gameId} | Get game info
[**gamesGameIdPost**](BasicsApi.md#gamesGameIdPost) | **POST** /games/{gameId} | Join a game
[**gamesGameIdStartPatch**](BasicsApi.md#gamesGameIdStartPatch) | **PATCH** /games/{gameId}/start | Start a game
[**gamesGet**](BasicsApi.md#gamesGet) | **GET** /games | Get all games
[**gamesPost**](BasicsApi.md#gamesPost) | **POST** /games | Create a new game


<a name="gamesGameIdGet"></a>
# **gamesGameIdGet**
> GameDetailResponse gamesGameIdGet(gameId)

Get game info

Get game info

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BasicsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    BasicsApi apiInstance = new BasicsApi(defaultClient);
    Long gameId = 56L; // Long | 
    try {
      GameDetailResponse result = apiInstance.gamesGameIdGet(gameId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BasicsApi#gamesGameIdGet");
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

### Return type

[**GameDetailResponse**](GameDetailResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Game info |  -  |
**404** | Cannot found game with this id |  -  |

<a name="gamesGameIdPost"></a>
# **gamesGameIdPost**
> GameDetailResponse gamesGameIdPost(gameId, joinGameRequest)

Join a game

Join a game

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BasicsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    BasicsApi apiInstance = new BasicsApi(defaultClient);
    Long gameId = 56L; // Long | 
    JoinGameRequest joinGameRequest = new JoinGameRequest(); // JoinGameRequest | The name of the player who will join the game
    try {
      GameDetailResponse result = apiInstance.gamesGameIdPost(gameId, joinGameRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BasicsApi#gamesGameIdPost");
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
 **joinGameRequest** | [**JoinGameRequest**](JoinGameRequest.md)| The name of the player who will join the game | [optional]

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
**200** | Game successfully joined |  -  |
**400** | The request is null, or the player name is null or the game cannot be started (already started, too many players) |  -  |
**404** | Game with this ID does not exist |  -  |

<a name="gamesGameIdStartPatch"></a>
# **gamesGameIdStartPatch**
> GameDetailResponse gamesGameIdStartPatch(gameId)

Start a game

Start a game

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BasicsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    BasicsApi apiInstance = new BasicsApi(defaultClient);
    Long gameId = 56L; // Long | 
    try {
      GameDetailResponse result = apiInstance.gamesGameIdStartPatch(gameId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BasicsApi#gamesGameIdStartPatch");
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

### Return type

[**GameDetailResponse**](GameDetailResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Game started successfully |  -  |
**404** | The game with this ID does not exist |  -  |

<a name="gamesGet"></a>
# **gamesGet**
> List&lt;GameListResponse&gt; gamesGet()

Get all games

Get all games

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BasicsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    BasicsApi apiInstance = new BasicsApi(defaultClient);
    try {
      List<GameListResponse> result = apiInstance.gamesGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BasicsApi#gamesGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;GameListResponse&gt;**](GameListResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |

<a name="gamesPost"></a>
# **gamesPost**
> GameDetailResponse gamesPost(createGameRequest)

Create a new game

Create a new game

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.BasicsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    BasicsApi apiInstance = new BasicsApi(defaultClient);
    CreateGameRequest createGameRequest = new CreateGameRequest(); // CreateGameRequest | The name of the first player of the game
    try {
      GameDetailResponse result = apiInstance.gamesPost(createGameRequest);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BasicsApi#gamesPost");
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
 **createGameRequest** | [**CreateGameRequest**](CreateGameRequest.md)| The name of the first player of the game | [optional]

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
**200** | Game created |  -  |
**400** | Bad request (request or name is null) |  -  |

