package pojoClasses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetUsersResponsePojo {

    public int id;
    public String name;
    public String company;
    public String username;
    public String email;
    public String address;
    public String zip;
    public String state;
    public String country;
    public String phone;
    public String photo;
}
