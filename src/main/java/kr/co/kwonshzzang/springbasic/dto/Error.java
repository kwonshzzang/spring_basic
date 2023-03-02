package kr.co.kwonshzzang.springbasic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Error {
    private String field;
    private String message;
    private String invalidValue;
}
