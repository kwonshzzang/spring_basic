package kr.co.kwonshzzang.springbasic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorResponse {
    private String statusCode;
    private String requestUrl;
    private String code;
    private String message;
    private String resultCode;

    private List<Error> errorList;
}
