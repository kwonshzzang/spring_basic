package kr.co.kwonshzzang.springbasic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserInfo {
    private String id;
    private String password;
    private String email;
}
