package lab1.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Embeddable
public class UserInfo {

    private String username;
    private String address;

    public UserInfo(){

    }
}
