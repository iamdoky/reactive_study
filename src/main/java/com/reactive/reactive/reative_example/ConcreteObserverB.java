package com.reactive.reactive.reative_example;

public class ConcreteObserverB implements Observer<String> {

    @Override
    public void observe(String event) {
        System.out.println("Observe B : " + event);
    }
}
