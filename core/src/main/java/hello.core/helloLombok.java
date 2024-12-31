package hello.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class helloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        helloLombok helloLombok = new helloLombok();
        helloLombok.setName("asd");
    }
}
