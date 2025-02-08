package objectModels;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.shaft.driver.SHAFT;
import pojoClasses.GetUsersRequestPojo;
import pojoClasses.GetUsersResponsePojo;

public class GetUsersRequestObject {

    //Variables
    private SHAFT.API api;
    private String getUsersEndpoint = "/users";
    private String responseBodyAsString;
    private JsonMapper mapper;

    //ObjectsFromPojoClasses
    private GetUsersRequestPojo requestObject;
    private GetUsersResponsePojo responseObject;

    //Prepare Get Request Parameters And Store it to Request Pojo Class
    public GetUsersRequestObject prepareGetUsersRequestWithID(String userID) {
        //Builder Pattern to Build Request Pojo Class with Request Parameters
        requestObject = GetUsersRequestPojo.builder()
                .id(userID)
                .build();
        return this;
    }

    //Method to Execute Get User By Request ID
    public GetUsersResponseObject sendGetUsersRequestByID(int statusCode) throws JsonProcessingException {
        api = new SHAFT.API(System.getProperty("baseURL1"));

        responseBodyAsString = api.get(getUsersEndpoint+"/{id}")
                .setTargetStatusCode(statusCode)
                .setPathParameters(requestObject.getId())
                .performRequest()
                .getBody()
                .asString();

        // Deserialize Json Response To Response Pojo Class
        mapper = new JsonMapper();
        responseObject = mapper.readValue(responseBodyAsString,GetUsersResponsePojo.class);

        return new GetUsersResponseObject(requestObject,responseObject);
    }
}
