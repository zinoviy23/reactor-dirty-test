package izmaylov.reatortest;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Processor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SynchronousSink;
import reactor.core.scheduler.Schedulers;
import reactor.util.annotation.NonNull;
import reactor.util.annotation.Nullable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Service
public class SomeService {
    public Mono<Integer> produce() {
        return Mono.just(1).map(i -> i + 3);
    }

    private Mono<Integer> mapper(int i) {
        System.out.println("Assembly!");

        return Mono.fromCallable(() -> {
            System.out.println("Processing!");
            return i + 1;
        });
    }

    @Nullable
    public String method(@NotNull String arg) {
        return null;
    }

    public String bob(String a) {
        return null;
    }

    @Nullable
    String lol() {
        return null;
    }

    @org.springframework.lang.Nullable
    String kek() {
        return null;
    }

    @Nullable
    String aaaa() {
        return null;
    }

    @NonNull
    String aaaaa() {
        return null;
    }

    static class Kek {
        @Nullable
        static String aaaa() {
            return null;
        }
    }

    private void kekek(Flux f) {

    }

    public int aa = 10;

    public Mono<Integer> doSomethingWithMono(@Nullable String kekkek) {
        String aaaa = kekkek == null ? null : "";

        Flux<Integer> ffff = (kekkek != null) ? Flux.just(1, 2, 3)
                .subscribeOn(Schedulers.single()) : Flux.just(1, 2, 3).subscribeOn(Schedulers.elastic());

        final @org.jetbrains.annotations.Nullable String a = null;;

        Flux.<Integer>create(e -> {
                    e.next(null);

            e.currentContext();
            e.complete();
        })
                .map(i -> {
                    String lol = lol();
                    return null;
                })
                .map(Function.identity())
                .map(i -> {
                    Object o = i;
                    return bob("a").toUpperCase();
                })
                .map(i -> bob("a").toUpperCase())
                .map(i -> bob("a").toUpperCase())
                .map(i -> {
                    String a1 = bob("a");
                    return a1.toUpperCase() + a1.toLowerCase();
                })
                .map(i -> {

                    return "a";
                })
                .flatMap(i -> Flux.just(i, i))
                .flatMap(i -> Flux.<String>error(new RuntimeException()))
                .filter(i -> i.length() < 3)
                .filter(i -> i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3)
                .filter(i -> i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3)
                .filter(i -> i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3)
                .filter(i -> i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3)
                .filter(i -> i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3 && i.length() < 3)
                .map(Integer::parseInt)
                .map(i -> Integer.toString(i + 1 + 2))
                .map(i -> i)
                .subscribeOn(Schedulers.parallel());

        Flux.just(1, 2)
                .publishOn(Schedulers.parallel())
//                .publishOn(Schedulers.elastic())
                .map(i -> Mono.just(1).block());

        Flux<Integer> fff = (a != null ? Flux.just(1, 2, 3) : Flux.just(2, 3, 4)).publishOn(Schedulers.parallel());

        Mono.just(1).flatMap(this::mapper);

        Processor<String, String> p = DirectProcessor.create();
        p.onError(null);

        System.out.println(aa);
        Flux.just(1, 2, 3)
                .<String>handle((i, sink) -> {
                    if (i > 3)
                        sink.next(Integer.toString(i));
                });

        Flux<String> stringFlux = Flux.just(1, 2, 3)
                .handle((i, sink) -> {
                    if (i > 3) sink.next(Integer.toString(i));
                });

        Flux.just(1, 2, 3)
                .handle((Integer i, SynchronousSink<Integer> sink) -> {
                    sink.next(i);
                });

        CompletableFuture<Integer> kek = CompletableFuture.completedFuture(10);
        System.out.println(Flux.just(kek.join()));

        bob(null);

        if (bob(null) != null) {

        }


        String mm = lol();

        String c = mm;

        c.charAt(0);

        Flux.just(10)
                .doOnNext(i -> {
                   Mono.just(1).block();
                });

        Stream.of(1, 2, 3)
                .map(i -> i + 1)
                .map(i -> i + 3).forEach(System.out::println);

        Flux<Integer> f = Flux.just(1, 2, 3).map(i -> i + 1).filter(i -> i > -1).flatMap(i -> Flux.just(i, i, i)).flatMap(Mono::just)
                .flatMap(Mono::just)
                .flatMap(Mono::just)
                .map(i -> i * 3);

        List<Flux> list = new LinkedList<>();
        Flux b = f;
        list.add(b);
        list.get(0);

        Flux<Integer> ff = Flux.just(12);

        ffff.map(i -> {
            Mono.just(1).subscribe();
            return 10;
        }).subscribe();

        Flux<Integer> z = Flux.just(1, 2, 3).subscribeOn(Schedulers.parallel());
        z.map(i -> Mono.just(1).block());

        System.out.println(ff);
//        ff.map(i -> i + 1);
//        kekek(ff);
//        ff.subscribe();

        Flux.using(() -> "", s -> {
            throw new RuntimeException();
        }, System.out::println)
                .map(i -> 10);

        Flux.just(1, 2, 3).flatMap((i) -> {
            throw new RuntimeException();
        });

        Flux.just(1, 2, 3).flatMap((i) -> {
            throw new RuntimeException();
        });

        Mono.just(1).flatMap((i) -> {
            throw new RuntimeException();
        });

        Flux.just(1, 2, 3).handle((i, sink) -> {
            if (i % 2 != 0) {
                throw new RuntimeException();
            } else {
                throw new RuntimeException("aa");
            }
        })
                .subscribe();

//        fff.subscribe();

        Flux.just(1, 2, 3)
                .subscribeOn(Schedulers.newParallel("p"))
                .map(i -> {
                    blocking();
                    Mono.just(1).block();
                    return i + 1;
                }).blockLast();

        Flux.just(1)
                .map(i -> i + 1)
                .map(i -> i + 3)
                .subscribe();

        fff.map(i -> {
            return Mono.just(1).block();
        });

        Flux<Integer> flux = Flux.just(1);

        {
            flux = Flux.just(1);
        }

        flux.subscribe();

        Flux<Integer> flux1 = Flux.just(1, 2, 3);
        flux1 = flux1.map(i -> Mono.just(1).block());
        flux1 = ThreadLocalRandom.current().nextBoolean() ? flux1.subscribeOn(Schedulers.parallel()) :
                flux1.subscribeOn(Schedulers.elastic());

        Flux<Integer> flux2 = Flux.just(1, 2, 3)
                .map(i -> i + 2)
                .subscribeOn(Schedulers.single());

        flux2.map(i -> Mono.just(1).block())
                .subscribeOn(Schedulers.parallel());

        Mono.just(10)
                .map(i -> Mono.just(i).block())
                .map(i -> {
                    Mono.just(1).subscribe();
                    return Mono.empty().block();
                })
                .subscribeOn(Schedulers.parallel())
                .subscribeOn(Schedulers.single());

        if (bob(null) != null) {
            flux2 = flux2.subscribeOn(Schedulers.immediate());
        } else {
            flux2 = flux2.subscribeOn(Schedulers.elastic());
        }

        flux2.subscribeOn(Schedulers.parallel());

        Flux<Integer> flux3 = Flux.just(1).map(i -> Mono.just(1).block());
//        flux3 = flux3.subscribeOn(Schedulers.parallel());
        flux3 = flux3.subscribeOn(Schedulers.elastic());
//        flux3 = flux3.subscribeOn(Schedulers.parallel());
        if (bob(null) != null) flux3 = flux3.subscribeOn(Schedulers.elastic());
        else flux3 = flux3.subscribeOn(Schedulers.parallel());
        flux3.map(i -> Mono.just(1).block()).map(i -> Mono.just(1).block()).subscribe();

        flux3.map(i -> {
            blocking();
            return i;
        }).flatMap(i -> {
            return Flux.just(Mono.just(1).block(), Mono.just(1).block());
        }).map(i -> Mono.just(1).block()).subscribe();

        Mono.just(1).as((m) -> (String)null).charAt(10);
        Supplier<String> function = () -> null;
        function.get().charAt(10);

        return Mono.empty();
    }

    private void blocking() {
        System.out.println(Schedulers.isInNonBlockingThread());
        //block
        Mono.just(1).block();
    }

    private void block() {

    }

//    public void use() {
//        Mono<Integer> m = Mono.just(1)
//                .publishOn(Schedulers.single());
//        useNonBlocking(m);
//    }

    public static void useNonBlocking(Mono<Integer> m) {
        m
                .map(i -> Mono.just(1).block());

        m
                .map(i -> Flux.just(1, 2, 3).blockFirst());
    }

    static class AAAA {
        public static void recursive(Mono<Integer> m) {
            m = m.map(i -> Mono.just(1).block());
            m = m.publishOn(Schedulers.parallel());
            recursive(m);
        }
    }

    void threeMaps() {
        Flux<Integer> f = Flux.just(1, 2, 3)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer i) {
                        return Mono.just(i).block();
                    }
                })
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer i) {
                        return Flux.just(i, i + 1).blockLast();
                    }
                })
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer i) {
                        return Mono.just(i).block();
                    }
                });

        f.subscribeOn(Schedulers.parallel());
    }

}
