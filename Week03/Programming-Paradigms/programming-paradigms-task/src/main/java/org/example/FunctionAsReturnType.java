package org.example;

import java.util.function.Function;

public class FunctionAsReturnType {

    public static void main(String[] args) {
    /*
    Function(var1){
        return Function(var2){
           return var1 * var2
           }
    }
     */

        Function<Integer, Function<Integer, Integer>> outerFunction = x -> y -> y * x;

        Function<Integer, Integer> innerFunction = outerFunction.apply(2);

        System.out.println(innerFunction.apply(5));

        System.out.println(outerFunction.apply(2).apply(5));
    }
}