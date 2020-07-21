package com.personal.codelearn.java.BO;

import com.personal.codelearn.config.WattInfo;
import lombok.Data;

@Data
public class TestUserBo {
    @WattInfo(pos = 0, className = String.class)
    private String name;
    @WattInfo(pos = 1, className = Integer.class)
    private Integer age;
    @WattInfo(pos = 2, className = Long.class)
    private Long classId;
    @WattInfo(pos = 3, className = Integer.class)
    private int userNo;
}
