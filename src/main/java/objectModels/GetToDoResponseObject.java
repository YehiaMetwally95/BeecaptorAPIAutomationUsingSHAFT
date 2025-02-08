package objectModels;

import com.google.gson.JsonObject;
import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.testng.Assert;
import pojoClasses.GetCompaniesRequestPojo;
import pojoClasses.GetCompaniesResponsePojo;

import java.util.List;

public class GetToDoResponseObject {
    private SHAFT.API api;

    //Constructor to pass the response from Request Model to Response Model
    public GetToDoResponseObject(SHAFT.API api) {
        this.api = api;
    }

    //Validation Methods
    public GetToDoResponseObject validateToDoCountFromResponse(int count) {
        List<Object> actualtoDoList = api.getResponseJSONValueAsList("$[*]");
        Validations.assertThat().object(actualtoDoList.size()).isEqualTo(count);
        return this;
    }

    public GetToDoResponseObject validateAllCompletedTitles(List<Object> completedTitlesList) {
        List<Object> actualCompletedTitlesList = api.getResponseJSONValueAsList("$[?(@.completed==true)].title");
        Validations.assertThat().object(actualCompletedTitlesList).isEqualTo(completedTitlesList);
        return this;
    }

    public GetToDoResponseObject validateAllNonCompletedTitles(List<Object> completedNonTitlesList) {
        List<Object> actualNonCompletedTitlesList = api.getResponseJSONValueAsList("$[?(@.completed==false)].title");
        Validations.assertThat().object(actualNonCompletedTitlesList).isEqualTo(completedNonTitlesList);
        return this;
    }

    public GetToDoResponseObject validateAllTitlesOfUser(int userId, List<Object> TitlesList) {

        List<Object> actualAllTitlesOfUser = api.getResponseJSONValueAsList("$[?(@.userId=="+userId+")].title");
        Validations.assertThat().object(actualAllTitlesOfUser).isEqualTo(TitlesList);
        return this;
    }

    public GetToDoResponseObject validateTitleByID(int id, String title) {
        String actualTitle = api.getResponseJSONValue("$[?(@.id=="+id+")].title");
        Validations.assertThat().object(actualTitle).isEqualTo(title);
        return this;
    }
}
