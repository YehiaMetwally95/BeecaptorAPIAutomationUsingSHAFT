package objectModels;

import com.shaft.validation.Validations;
import pojoClasses.GetCompaniesRequestPojo;
import pojoClasses.GetCompaniesResponsePojo;
import pojoClasses.GetUsersRequestPojo;
import pojoClasses.GetUsersResponsePojo;

public class GetCompaniesResponseObject {
    //Variables

    //ObjectsFromPojoClasses
    private GetCompaniesRequestPojo requestObject;
    private GetCompaniesResponsePojo[] responseObject;

    //Constructor to pass the response from Request Model to Response Model
    public GetCompaniesResponseObject(GetCompaniesRequestPojo requestObject, GetCompaniesResponsePojo[] responseObject) {
        this.requestObject = requestObject;
        this.responseObject= responseObject;
    }

    //Validation Methods
    public GetCompaniesResponseObject validateCompaniesCountFromResponse(int count) {
        Validations.assertThat().object(responseObject.length).isEqualTo(count);
        return this;
    }

    public GetCompaniesResponseObject validateIdOfFirstCompany(int id) {
        Validations.assertThat().object(responseObject[0].getId()).isEqualTo(id);
        return this;
    }
}
