package hello.springmvc.basic;

import lombok.Data;

@Data //Getter, Stter, toString 기능 제공
public class HelloData {
    private String username;
    private int age;
}
