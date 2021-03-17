package com.cjs.scalaAdvanceLearn.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>(List.of(1,2,3,4,5));

        List<Integer> integerList = integers.stream().map(a -> a * 2).collect(Collectors.toList());

        System.out.println(integerList.getClass());


    }
}
