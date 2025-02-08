package objectModels;

import com.shaft.driver.SHAFT;

public class GetPostsRequestObject {

    //Variables
    private SHAFT.API api;
    private String ToDoEndpoint = "/posts";

    //Method to Execute Get All Posts
    public GetPostsResponseObject sendGetPostsRequest(int statusCode) {
        api = new SHAFT.API(System.getProperty("baseURL2"));

        api.get(ToDoEndpoint)
                .setTargetStatusCode(statusCode)
                .performRequest();

        return new GetPostsResponseObject(api);
    }
}
