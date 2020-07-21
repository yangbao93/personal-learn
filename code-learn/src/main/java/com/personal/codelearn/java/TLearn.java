package com.personal.codelearn.java;

import com.personal.codelearn.java.BO.TestUserBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class TLearn {


    private static <T> void setWattValue(int pos, String[] splitList, Class<T> tClass,
                                         String methodName, TestUserBo wattBo) {
        if (pos >= splitList.length) {
            log.error("数组长度为{},指针位置为{},已经超出限制,程序返回", splitList.length, pos);
            return;
        }
        if (StringUtils.isEmpty(splitList[pos])) {
            log.error("获取到的数据为空,没有执行意义,返回");
            return;
        }
        try {
            Method method = wattBo.getClass().getMethod(methodName, tClass);
            // 处理int型
            if (tClass.getName().equals(Integer.class.getName())) {
                Integer tempValue = Integer.valueOf(splitList[pos]);
                method.invoke(wattBo, tempValue);
            } else if (tClass.getName().equals(String.class.getName())) {
                String tempValue = splitList[pos];
                method.invoke(wattBo, tempValue);
            } else if (tClass.getName().equals(Long.class.getName())) {
                Long tempValue = Long.valueOf(splitList[pos]);
                method.invoke(wattBo, tempValue);
            }
        } catch (NoSuchMethodException e) {
            log.error("设置属性值是否发生NoSuchMethodException错误,错误原因为{}", e.getMessage());
        } catch (IllegalAccessException e) {
            log.error("设置属性值是否发生IllegalAccessException错误,错误原因为{}", e.getMessage());
        } catch (InvocationTargetException e) {
            log.error("设置属性值是否发生InvocationTargetException错误,错误原因为{}", e.getMessage());
        }
    }

    public static void main(String[] args) {
        String[] a = new String[]{"test", "1", "19700101","21",""};
        TestUserBo bo = new TestUserBo();
        setWattValue(0, a, String.class, "setName", bo);
        setWattValue(1, a, Integer.class, "setAge", bo);
        setWattValue(3, a, Integer.class, "setUserNo", bo);
        setWattValue(10, a, Integer.class, "setUserNo", bo);
        setWattValue(4, a, Integer.class, "setUserNo", bo);
    }
}

