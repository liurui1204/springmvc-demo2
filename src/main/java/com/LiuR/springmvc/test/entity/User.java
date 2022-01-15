package com.LiuR.springmvc.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
public class User {
    private Integer iid;
    private String name;
    private String gender;
    private Integer age;
}
