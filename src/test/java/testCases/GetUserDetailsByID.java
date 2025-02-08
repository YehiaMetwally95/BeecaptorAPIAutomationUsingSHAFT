package testCases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shaft.driver.SHAFT;
import objectModels.GetUsersRequestObject;
import org.testng.annotations.Test;

public class GetUserDetailsByID {
    //Variables
    private SHAFT.TestData.JSON testData;
    private static final String testDataJsonPath = "GetUsersTestData.json";

    @Test
    public void getUserDetailsByUserID() throws JsonProcessingException {
        testData = new SHAFT.TestData.JSON(testDataJsonPath);

        new GetUsersRequestObject()
                .prepareGetUsersRequestWithID(testData.getTestData("UserDetails.id"))
                .sendGetUsersRequestByID(Integer.parseInt(testData.getTestData("GetUsersStatusCode")))
                .validateIDFromResponse(testData.getTestData("UserDetails.id"))
                .validateNameFromResponse()
                .validateCompanyFromResponse()
                .validateUserNameFromResponse()
                .validateEmailFromResponse()
                .validateAddressFromResponse()
                .validateZipFromResponse()
                .validateStateFromResponse()
                .validateCountryFromResponse()
                .validatePhoneFromResponse()
                .validatePhotoFromResponse();
    }
}
