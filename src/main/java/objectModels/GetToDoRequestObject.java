package objectModels;

import com.shaft.driver.SHAFT;

public class GetToDoRequestObject {

    //Variables
    private SHAFT.API api;
    private String ToDoEndpoint = "/todos";

    //Method to Execute Get All To Do List
    public GetToDoResponseObject sendGetToDoRequest(int statusCode) {
        api = new SHAFT.API(System.getProperty("baseURL2"));

        api.get(ToDoEndpoint)
                .setTargetStatusCode(statusCode)
                .performRequest();

        return new GetToDoResponseObject(api);
    }
}
