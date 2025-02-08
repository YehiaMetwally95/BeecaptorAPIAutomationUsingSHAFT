package objectModels;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;

import java.util.List;

public class GetPostsResponseObject {
    private SHAFT.API api;

    //Constructor to pass the response from Request Model to Response Model
    public GetPostsResponseObject(SHAFT.API api) {
        this.api = api;
    }

    //Validation Methods
    public GetPostsResponseObject validatePostsCountFromResponse(int count) {
        List<Object> actualPostsList = api.getResponseJSONValueAsList("$[*]");
        Validations.assertThat().object(actualPostsList.size()).isEqualTo(count);
        return this;
    }

    public GetPostsResponseObject validateCommentsCountByPostLink(String postLink,int expectedCommentsCount) {
        int actualCommentsCount = Integer.parseInt(api.getResponseJSONValue("$[?(@.link=='"+postLink+"')].comment_count"));
        Validations.assertThat().object(actualCommentsCount).isEqualTo(expectedCommentsCount);
        return this;
    }

    public GetPostsResponseObject validatePostBodyByPostTitle(String postTitle,String expectedPostBody) {
        String actualPostBody = api.getResponseJSONValue("$[?(@.title=='"+postTitle+"')].body");
        Validations.assertThat().object(actualPostBody).isEqualTo(expectedPostBody);
        return this;
    }
}
