package testCases;

import com.shaft.driver.SHAFT;
import objectModels.GetToDoRequestObject;
import org.testng.annotations.Test;

import java.util.List;

public class GetToDoListDetails {
    //Variables
    private SHAFT.TestData.JSON testData;
    private static final String testDataJsonPath = "GetToDoListTestData.json";

    @Test
    public void verifyToDoListByStatus() {
        testData = new SHAFT.TestData.JSON(testDataJsonPath);

        new GetToDoRequestObject()
                .sendGetToDoRequest(Integer.parseInt(testData.getTestData("GetToDoListStatusCode")))
                .validateToDoCountFromResponse(Integer.parseInt(testData.getTestData("ToDoListCount")))
                .validateAllCompletedTitles((List<Object>) testData.getTestDataAsList("CompletedToDoList"))
                .validateAllNonCompletedTitles((List<Object>) testData.getTestDataAsList("NonCompletedToDoList"));
    }

    @Test
    public void verifyListOfToDoTitlesForUser() {
        testData = new SHAFT.TestData.JSON(testDataJsonPath);

        new GetToDoRequestObject()
                .sendGetToDoRequest(Integer.parseInt(testData.getTestData("GetToDoListStatusCode")))
                .validateToDoCountFromResponse(Integer.parseInt(testData.getTestData("ToDoListCount")))
                .validateAllTitlesOfUser(Integer.parseInt(testData.getTestData("FirstUser.Id"))
                        , (List<Object>) testData.getTestDataAsList("FirstUser.Titles"));
    }

    @Test
    public void verifyToDoTitleByID() {
        testData = new SHAFT.TestData.JSON(testDataJsonPath);

        new GetToDoRequestObject()
                .sendGetToDoRequest(Integer.parseInt(testData.getTestData("GetToDoListStatusCode")))
                .validateToDoCountFromResponse(Integer.parseInt(testData.getTestData("ToDoListCount")))
                .validateTitleByID(Integer.parseInt(testData.getTestData("TitleOne.Id"))
                        ,testData.getTestData("TitleOne.Name"));;
    }
}
