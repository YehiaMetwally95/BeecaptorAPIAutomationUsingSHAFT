package objectModels;

import com.shaft.validation.Validations;
import pojoClasses.GetUsersRequestPojo;
import pojoClasses.GetUsersResponsePojo;

public class GetUsersResponseObject {
    //Variables

    //ObjectsFromPojoClasses
    private GetUsersRequestPojo requestObject;
    private GetUsersResponsePojo responseObject;

    //Constructor to pass the response from Request Model to Response Model
    public GetUsersResponseObject(GetUsersRequestPojo requestObject,GetUsersResponsePojo responseObject) {
        this.requestObject = requestObject;
        this.responseObject= responseObject;
    }

    //Validation Methods
    public GetUsersResponseObject validateIDFromResponse(String id) {
        int actualID = responseObject.getId();
        int expectedID = Integer.parseInt(id);
        Validations.assertThat().object(actualID).isEqualTo(expectedID);
        return this;
    }

    public GetUsersResponseObject validateNameFromResponse() {
        Validations.assertThat().object(responseObject.getName()).isNotNull();
        return this;
    }

    public GetUsersResponseObject validateCompanyFromResponse() {
        Validations.assertThat().object(responseObject.getCompany()).isNotNull();
        return this;
    }

    public GetUsersResponseObject validateUserNameFromResponse() {
        Validations.assertThat().object(responseObject.getUsername()).isNotNull();
        return this;
    }

    public GetUsersResponseObject validateEmailFromResponse() {
        Validations.assertThat().object(responseObject.getEmail()).isNotNull();
        return this;
    }

    public GetUsersResponseObject validateAddressFromResponse() {
        Validations.assertThat().object(responseObject.getAddress()).isNotNull();
        return this;
    }

    public GetUsersResponseObject validateZipFromResponse() {
        Validations.assertThat().object(responseObject.getZip()).isNotNull();
        return this;
    }

    public GetUsersResponseObject validateStateFromResponse() {
        Validations.assertThat().object(responseObject.getState()).isNotNull();
        return this;
    }

    public GetUsersResponseObject validateCountryFromResponse() {
        Validations.assertThat().object(responseObject.getCountry()).isNotNull();
        return this;
    }

    public GetUsersResponseObject validatePhoneFromResponse() {
        Validations.assertThat().object(responseObject.getPhone()).isNotNull();
        return this;
    }

    public GetUsersResponseObject validatePhotoFromResponse() {
        Validations.assertThat().object(responseObject.getPhoto()).isNotNull();
        return this;
    }
}
