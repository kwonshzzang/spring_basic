package kr.co.kwonshzzang.springbasic.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequest {
    private String name;
    private String email;
    private int age;

    @Override
   public String toString() {
        return "UserRequest {" +
                "name = '" + name + "\' ," +
                "email = '" + email + "\' ," +
                "age = '" + age +
                "}";
    }
}
