package com.reactive.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ReactiveApplication {

	public static void main(String[] args) {
		Flux<String> flux = Flux.just("A");
		Flux<String> flux2 = flux.map(i -> "foo" + i);
		flux.subscribe(System.out::println);
	}

}
