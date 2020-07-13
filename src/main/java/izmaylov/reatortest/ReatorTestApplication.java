package izmaylov.reatortest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.HooksKek;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Supplier;

@SpringBootApplication
public class ReatorTestApplication {
    public static void main(String[] args) {
//        Hooks.onOperatorDebug();

//        Flux.just(1, 2, 3)
//                .map(i -> i + 2)
//                .filter(i -> true)
//                .filter(i -> true)
//                .filter(i -> true)
//                .flatMap(i -> new SomeService().produce())
//                .map(i -> {
//                    //Breakpoint!
//                    return i + 4;
//                }).subscribe();

//        new HooksKek().run();

        System.out.println("" + Flux.just(1).as(i -> null));

//        LolUtil.fromKotlin()
//                .map(i -> i + 1)
//                .subscribe();
    }
}
