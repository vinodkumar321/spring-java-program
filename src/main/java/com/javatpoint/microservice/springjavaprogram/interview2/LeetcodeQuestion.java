package com.javatpoint.microservice.springjavaprogram.interview2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LeetcodeQuestion {
    public static void main(String args[]) {
        String str = "loveleetcode";
        System.out.println(str);
        char[] arr = str.toCharArray();
        int result = -1;
        List<Character> list = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Optional<Character> ch = list.stream().filter(i -> Collections.frequency(list,i) == 1).findFirst();
        if(!ch.isEmpty())
            str.indexOf(ch.get());

    }
}
