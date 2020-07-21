package com.personal.codelearn.java;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class ListLearn {

    public static void main(String[] args) {
        List<String> oriList = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        for (int i = 0; i < oriList.size(); i++) {
            oriList.set(i, oriList.get(i) + "-");
        }
        log.info("");
        Iterator<String> iterator = oriList.iterator();
        while (iterator.hasNext()) {
            // ConcurrentModificationException
            // oriList.add(iterator.next() + "-");
        }
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>(Arrays.asList("A", "B", "C", "D"));
    }
}
