package kr.co.kwonshzzang.springbasic.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import kr.co.kwonshzzang.springbasic.annotation.YearMonth;
import kr.co.kwonshzzang.springbasic.dto.objectmapper.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @NotBlank
    private String name;
    @Max(value = 90)
    private Integer age;
    @Email
    private String email;
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. 01x-xxx(x)-xxxxx")
    private String phoneNumber;
    private String address;

   @YearMonth
    private String reqYearMonth;  //yyyyMM

    @Valid
    private List<Car> cars;

//    @AssertTrue(message = "yyyyMM의 형식에 맞지 않습니다.")
//    public boolean isReqYearMonthValidation() {
//        try {
//            LocalDate localDate = LocalDate.parse(this.reqYearMonth + "01", DateTimeFormatter.ofPattern("yyyyMMdd"));
//            return true;
//        } catch(Exception e) {
//            return false;
//        }
//    }
}
