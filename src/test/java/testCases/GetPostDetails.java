package testCases;

import com.shaft.driver.SHAFT;
import objectModels.GetPostsRequestObject;
import objectModels.GetToDoRequestObject;
import org.testng.annotations.Test;

import java.util.List;

public class GetPostDetails {
    //Variables
    private SHAFT.TestData.JSON testData;
    private static final String testDataJsonPath = "GetPostsTestData.json";

    @Test
    public void verifyCommentsCountForPost() {
        testData = new SHAFT.TestData.JSON(testDataJsonPath);

        new GetPostsRequestObject()
                .sendGetPostsRequest(Integer.parseInt(testData.getTestData("GetPostsStatusCode")))
                .validatePostsCountFromResponse(Integer.parseInt(testData.getTestData("PostsCount")))
                .validateCommentsCountByPostLink(testData.getTestData("FirstPost.Link"),
                        Integer.parseInt(testData.getTestData("FirstPost.CommentsCount")));
    }

    @Test
    public void verifyPostBodyByTitle() {
        testData = new SHAFT.TestData.JSON(testDataJsonPath);

        new GetPostsRequestObject()
                .sendGetPostsRequest(Integer.parseInt(testData.getTestData("GetPostsStatusCode")))
                .validatePostsCountFromResponse(Integer.parseInt(testData.getTestData("PostsCount")))
                .validatePostBodyByPostTitle(testData.getTestData("FirstPost.Title"),
                        testData.getTestData("FirstPost.Body"));
    }

}
