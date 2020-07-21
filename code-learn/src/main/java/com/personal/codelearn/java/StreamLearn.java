package com.personal.codelearn.java;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class StreamLearn {

    @Data
    public class TestUser {
        private String name;
        private Integer age;
    }

    @Data
    public class Student {
        private String name;
        private Integer age;
        private Integer stature;
        private String specialities;

        Student(String name, Integer age, Integer stature, String specialities) {
            this.name = name;
            this.age = age;
            this.stature = stature;
            this.specialities = specialities;
        }

        Student(String name, Integer age, Integer stature) {
            this.name = name;
            this.age = age;
            this.stature = stature;
        }
    }


    List<Integer> initIntList() {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        return arr;
    }

    List<TestUser> initUserList() {
        TestUser tu1 = new TestUser();
        tu1.setName("tom");
        tu1.setAge(1);
        TestUser tu2 = new TestUser();
        tu2.setName("jerry");
        tu2.setAge(2);
        TestUser tu3 = new TestUser();
        tu3.setName("mary");
        tu3.setAge(2);
        TestUser tu4 = new TestUser();
        tu4.setName("john");
        tu4.setAge(4);
        return Arrays.asList(tu1, tu2, tu3, tu4);
    }

    List<Student> testFlatMap() {
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));

        List<Student> studentList = Stream.of(students,
                Arrays.asList(new Student("艾斯", 25, 183),
                        new Student("雷利", 48, 176)))
                .flatMap(students1 -> students1.stream()).collect(Collectors.toList());
        return studentList;
    }

    public static void main(String[] args) {
        StreamLearn sl = new StreamLearn();
        List<Integer> list = sl.initIntList();
        List<Integer> filterList = list.stream().filter(s -> s > 3).collect(Collectors.toList());
        log.info("filter 后的List为:{}", JSONObject.toJSONString(filterList));
        Integer minInt = list.stream().min((x, y) -> (x.compareTo(y))).get();
        Integer maxInt = list.stream().max((x, y) -> (x.compareTo(y))).get();
        Integer maxInt2 = list.stream().max(Integer::compareTo).get();
        log.info("List的min是{},max是{},max2是{}", minInt, maxInt, maxInt2);
        list.stream().forEach(e -> e++);
        List<Integer> peekList = list.stream().peek(e -> e++).collect(Collectors.toList());
        log.info("peek e++ 后的结果为{}", JSONObject.toJSONString(peekList));
        List<Integer> limitList = list.stream().filter(s -> s > 3).limit(1).collect(Collectors.toList());
        log.info("limit 后的结果为{}", JSONObject.toJSONString(limitList));
        List<String> mapList = list.stream().map(e -> e + "-").collect(Collectors.toList());
        List<Integer> mapList2 = list.stream().map(e -> (e++)).collect(Collectors.toList());
        log.info("map 后的结果为{}", JSONObject.toJSONString(mapList));
        log.info("map2 后的结果为{}", JSONObject.toJSONString(mapList2));
        Integer reduceAdd = list.stream().reduce((x, y) -> (x + y)).get();
        log.info("reduceAdd 后的结果为{}", reduceAdd);
        list.parallelStream().forEach(e -> System.out.println(e));
//        log.info("parallel 后的结果为{}", JSONObject.toJSONString(parallelList));
        List<TestUser> userList = sl.initUserList();
        Map<Integer, List<TestUser>> groupList = userList.stream().collect(Collectors.groupingBy(TestUser::getAge));
        log.info("groupingBy 后的结果为{}", JSONObject.toJSONString(groupList));
        log.info("flatmap 后的结果为{}", JSONObject.toJSONString(sl.testFlatMap()));
    }
}
