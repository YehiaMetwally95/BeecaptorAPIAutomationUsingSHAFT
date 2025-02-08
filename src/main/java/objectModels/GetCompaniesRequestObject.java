package objectModels;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.shaft.driver.SHAFT;
import pojoClasses.GetCompaniesRequestPojo;
import pojoClasses.GetCompaniesResponsePojo;

public class GetCompaniesRequestObject {

    //Variables
    private SHAFT.API api;
    private String getCompaniesEndpoint = "/companies";
    private String responseBodyAsString;
    private JsonMapper mapper;

    //ObjectsFromPojoClasses
    private GetCompaniesRequestPojo requestObject;
    private GetCompaniesResponsePojo[] responseObject;

    //Method to Execute Get All Companies
    public GetCompaniesResponseObject sendGetAllCompaniesRequest(int statusCode) throws JsonProcessingException {
        api = new SHAFT.API(System.getProperty("baseURL1"));

        responseBodyAsString = api.get(getCompaniesEndpoint)
                .setTargetStatusCode(statusCode)
                .performRequest()
                .getBody()
                .asString();

        // Deserialize Json Response To Response Pojo Class
        mapper = new JsonMapper();
        responseObject = mapper.readValue(responseBodyAsString, GetCompaniesResponsePojo[].class);

        return new GetCompaniesResponseObject(requestObject,responseObject);
    }
}
