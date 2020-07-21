package com.personal.codelearn.java;

import com.personal.codelearn.config.WattInfo;
import com.personal.codelearn.java.BO.TestUserBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

@Slf4j
public class UserAnnLearn {


    private static <T> void setWattValue(int pos, String[] splitList, Class<?> tClass,
                                         Field field, TestUserBo wattBo) {
        if (pos >= splitList.length) {
            log.error("数组长度为{},指针位置为{},已经超出限制,程序返回", splitList.length, pos);
            return;
        }
        if (StringUtils.isEmpty(splitList[pos])) {
            log.error("获取到的数据为空,没有执行意义,返回");
            return;
        }
        try {
            // 处理int型
            if (tClass.getName().equals(Integer.class.getName())) {
                Integer tempValue = Integer.valueOf(splitList[pos]);
                field.set(wattBo, tempValue);
            } else if (tClass.getName().equals(String.class.getName())) {
                String tempValue = splitList[pos];
                field.set(wattBo, tempValue);
            } else if (tClass.getName().equals(Long.class.getName())) {
                Long tempValue = Long.valueOf(splitList[pos]);
                field.set(wattBo, tempValue);
            }
        } catch (IllegalAccessException e) {
            log.error("设置属性值是否发生IllegalAccessException错误,错误原因为{}", e.getMessage());
        }
    }

    public static void main(String[] args) {
        String[] a = new String[]{"test", "1", "19700101", "21", ""};
        TestUserBo bo = new TestUserBo();
        Field[] fields = bo.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field tempField = fields[i];
            tempField.setAccessible(Boolean.TRUE);
            WattInfo wattInfo = tempField.getAnnotation(WattInfo.class);
            setWattValue(i, a, wattInfo.className(), tempField, bo);
        }
    }
}

