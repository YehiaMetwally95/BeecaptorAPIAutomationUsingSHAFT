package pojoClasses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GetCompaniesResponsePojo {

    public int id;
    public String name;
    public String address;
    public String zip;
    public String country;
    public int employeeCount;
    public String industry;
    public long marketCap;
    public String domain;
    public String logo;
    public String ceoName;
}
