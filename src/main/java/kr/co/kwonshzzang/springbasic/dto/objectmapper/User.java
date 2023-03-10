package kr.co.kwonshzzang.springbasic.dto.objectmapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class User {
    private String name;
    private int age;
    private List<Car> cars;
}
