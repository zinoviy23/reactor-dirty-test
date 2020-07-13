package izmaylov.reatortest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ForTest {
    public static void f() {
        String s =  ThreadLocalRandom.current().nextBoolean() ? "" : null;
        Flux.just(1, 2, 3).map(i -> {
            if (s != null)
                return s;
            return "a";
        });

        Flux<Integer> f = Flux.just(1, 2, 3)
                .<Integer>handle((i, sink) -> {
                    if (i % 2 == 0) sink.next(i + 2);
                });


        Flux.just(1, 2, 3).map(i -> i + 1);



        Flux<Integer> ff = Flux.just(1, 2, 3)
                .map(i -> i + 1);


        System.out.println(ff);


        Flux.just(1, 2, 3)
                .flatMap(i -> {
                    if (i > 2)
                        return Flux.error(new RuntimeException());
                    return Mono.just(1);
                });


        f.subscribe();


//        int i = 10;
        Flux.just(1, 2, 3)
                .map(i -> i + 1)
                .map(i -> i + 2)
                .map(z -> z + 2 + 2);

        Flux.just(1, 2, 3)
                .filter(i -> i + 1 < 1)
                .map(String::valueOf);
    }
}
