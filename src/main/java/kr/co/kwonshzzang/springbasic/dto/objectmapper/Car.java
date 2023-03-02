package kr.co.kwonshzzang.springbasic.dto.objectmapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class Car {
    @NotBlank
    private String name;
    @NotBlank
    @JsonProperty("car_number")
    private String carNumber;
    @NotBlank
    @JsonProperty("TYPE")
    private String type;
}
