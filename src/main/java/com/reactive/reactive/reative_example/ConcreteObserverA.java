package com.reactive.reactive.reative_example;

public class ConcreteObserverA implements Observer<String> {

    @Override
    public void observe(String event) {
        System.out.println("Observe A : " + event);
    }
}
