package ru.otus.klem.tests.Main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static ru.otus.klem.hw30logtest.CheckArrarys.checkVal;
import static ru.otus.klem.hw30logtest.CheckArrarys.newArray;

public class TestsHw30 {

    @MethodSource("checkNewArray")
    @ParameterizedTest
    public void checkNewArrayTest(int[] array, int[] res) {
        Assertions.assertEquals(Arrays.toString(res), Arrays.toString(newArray(array)));
        Assertions.assertThrows(RuntimeException.class, () -> {
            newArray(new int[]{2, 2, 2, 2});
        });
    }

    public static Stream<Arguments> checkNewArray() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 2, 1, 2, 2}, new int[]{2, 2}));
        out.add(Arguments.arguments(new int[]{1, 0, 2, 1, 2, 1, 0, 4, 8}, new int[]{0, 4, 8}));
        return out.stream();
    }

    @MethodSource("checkArrays")
    @ParameterizedTest
    public void checkArraysTest(int[] b, boolean res) {
        Assertions.assertEquals(checkVal(b), res);
    }


    public static Stream<Arguments> checkArrays() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 3}, false));
        out.add(Arguments.arguments(new int[]{1, 2}, true));
        out.add(Arguments.arguments(new int[]{1, 1}, false));
        out.add(Arguments.arguments(new int[]{2, 2, 2, 2, 2}, false));
        out.add(Arguments.arguments(new int[]{1, 2, 2, 1}, true));
        return out.stream();
    }

}
