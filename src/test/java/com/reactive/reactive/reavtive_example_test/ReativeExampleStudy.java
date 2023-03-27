package com.reactive.reactive.reavtive_example_test;

import com.reactive.reactive.reative_example.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReativeExampleStudy {

    @Test
    public void observerHandlerEventFromSubject() {
        // given
        Subject<String> subject = new ConcreteSubject();
        Observer<String> observerA = Mockito.spy(new ConcreteObserverA());
        Observer<String> observerB = Mockito.spy(new ConcreteObserverB());

        // when
        subject.notifyObserver("No Listeners");

        subject.registerObserver(observerA);
        subject.notifyObserver("Message for A");

        subject.registerObserver(observerB);
        subject.notifyObserver("Message for A & B");

        subject.unregisterObserver(observerA);
        subject.notifyObserver("Message for B");

        subject.unregisterObserver(observerB);
        subject.notifyObserver("No listener");

        // then
        Mockito.verify(observerA, Mockito.times(1)).observe("Message for A");
        Mockito.verify(observerA, Mockito.times(1)).observe("Message for A & B");
        Mockito.verifyNoMoreInteractions(observerA);

        Mockito.verify(observerB, Mockito.times(1)).observe("Message for A & B");
        Mockito.verify(observerB, Mockito.times(1)).observe("Message for B");
        Mockito.verifyNoMoreInteractions(observerB);
    }

    @Test
    public void subjectLeveragesLambdas() {
        Subject<String> subject = new ConcreteSubject();

        subject.registerObserver(e -> System.out.println("A : " + e));
        subject.unregisterObserver(e -> System.out.println("B : " + e));
        subject.notifyObserver("This message will receive A & B");

    }

}
