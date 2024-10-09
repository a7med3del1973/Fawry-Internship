package org.example;

import java.util.function.Consumer;

public class MethodAsParameter {


    public static void register(String name, Consumer<String> makeEmail){
        makeEmail.accept(name+"@example.com");
    }

    public static void sendWelcomeMail(String mail) {
        System.out.println("Hello new user " + mail);
    }
    public static void main(String[] args){

        register("adel",MethodAsParameter::sendWelcomeMail);

    }

}