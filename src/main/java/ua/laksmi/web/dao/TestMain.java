package ua.laksmi.web.dao;

import java.util.Arrays;

/**
 * Created by Dobriks on 15.04.2017.
 */
public class TestMain {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        System.out.println(Arrays.toString(a).replace("[","(").replace("]",")"));
    }
}
