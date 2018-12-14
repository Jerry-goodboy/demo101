package com.github.binarywang.demo.wx.cp.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestXmlDataEntity {
    @Getter
    @Setter
    private String name = "tom";

    @Getter
    @Setter
    private int age = 10;

    @Getter
    @Setter
    private boolean active = true;

    @Getter
    @Setter
    private Date date = new Date();

//    /**
//     * Name of the person.
//     * -- SETTER --
//     * Changes the name of this person.
//     *
//     * @param name The new value.
//     */
//    @Setter(AccessLevel.PROTECTED) private String name;

    @Override public String toString() {
        return String.format("%s (age: %d)", name, age);
    }
}
