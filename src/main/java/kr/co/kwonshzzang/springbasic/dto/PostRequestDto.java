package kr.co.kwonshzzang.springbasic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PostRequestDto {
    private String account;
    private String email;
    private String address;
    private String password;
    @JsonProperty("phone_number")
    private String phoneNumber; //phone_number;
    @JsonProperty("OTP")
    private String OTP;
}
