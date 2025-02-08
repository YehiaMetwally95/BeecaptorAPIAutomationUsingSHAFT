package testCases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shaft.driver.SHAFT;
import objectModels.GetCompaniesRequestObject;
import objectModels.GetUsersRequestObject;
import org.testng.annotations.Test;

public class GetAllCompanies {
    //Variables
    private SHAFT.TestData.JSON testData;
    private static final String testDataJsonPath = "GetCompaniesTestData.json";

    @Test
    public void getAllCompaniesDetails() throws JsonProcessingException {
        testData = new SHAFT.TestData.JSON(testDataJsonPath);

        new GetCompaniesRequestObject()
                .sendGetAllCompaniesRequest(Integer.parseInt(testData.getTestData("GetCompaniesStatusCode")))
                .validateCompaniesCountFromResponse(Integer.parseInt(testData.getTestData("CompaniesCount")))
                .validateIdOfFirstCompany(Integer.parseInt(testData.getTestData("CompaniesDetails.id")));
    }

}
