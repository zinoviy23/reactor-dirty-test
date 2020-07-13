package izmaylov.reatortest;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Aaaa {
    @Test
    public void name() {
        Hooks.onOperatorDebug();
        Flux.just(1, 2, 3)
                .<String>handle((i, sink) -> {
//                    sink.error(new RuntimeException());
                    sink.next(i + "");
                    System.out.println("aaaa");
                })
                .doOnError(System.out::println)
                .filter(i -> i.length() > 3 )
                .subscribeOn(Schedulers.elastic())
                .flatMap(s -> Mono.fromFuture(CompletableFuture.completedFuture(10)))
                .subscribe(s -> {});
    }

    @Test
    public void exception() {
        Flux.just(1, 2, 3).map(i -> null).subscribe();
    }

    public Mono<Integer> m() {
        return Mono.just(1);
    }

    @Test
    public void innerPublishOn() throws InterruptedException {
        Flux.just(1, 2, 3)
                .flatMap(i -> Flux.just(i, i).subscribeOn(Schedulers.parallel()))
                .map(i -> {
                    return Mono.fromFuture(CompletableFuture.completedFuture(i)).block();
                })
                .subscribe();

        Thread.sleep(1000);
    }

    @Test
    public void kek() {
//        Hooks.onOperatorDebug();
        Flux.range(0, 5)
                .subscribeOn(Schedulers.parallel())
                .subscribeOn(Schedulers.single())
                .checkpoint()
//                .checkpoint("aaaa")
//                .subscribeOn(Schedulers.elastic())
//                .publishOn(Schedulers.elastic())
                .hide()
                .map(i -> i + 2)
                .doOnNext(i -> System.out.println(i))
                .flatMap(i -> Flux.just(i + 1, i))
                .flatMap(i -> m())
                .<Integer>handle((i, sink) -> sink.next(i + 1))
                .map(i -> {
                    CountDownLatch latch = new CountDownLatch(1);

                    Mono.delay(Duration.ofMillis(i * 100))
                            .subscribe(__ -> latch.countDown());

                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    return i;
                })
                .blockLast();
        Flux.just(1);
    }

    @Test
    public void tetetetes() {
        Hooks.onOperatorDebug();

        Flux.just(1)
                .map(i -> i + 1)
                .filter(i -> i > 0)
                .flatMap(i -> Mono.just(i))
                .map(i -> {
                    // Breakpoint!
                    return i;
                }).map(i -> Integer.toString(i))
                .map(i -> new String[] { i })
                .doOnNext(x -> System.out.println(x))
                .subscribe();

        AtomicInteger num = new AtomicInteger();
    }

    @Test
    public void kek1() {
        Flux.range(0, 10)
                .publishOn(Schedulers.parallel())
                .map(i -> Mono.fromFuture(CompletableFuture.completedFuture(10)).block())
                .publishOn(Schedulers.parallel())
                .blockLast();
    }

    @Test
    public void name2() {
        Flux<Integer> f;

        try {
            f = Flux.just(1);
        } catch (RuntimeException e) {
            f = Flux.just(2);
        }

        f.subscribe();
    }

    @Test
    public void delay() {
        Mono.delay(Duration.ofMillis(100))
                .map(value -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(Schedulers.isInNonBlockingThread());
                    return Mono.fromFuture(CompletableFuture.supplyAsync(() -> {
                        try {
                            System.out.println(Thread.currentThread().getName());
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return value;
                    })).block();
                })
                .block();
    }

    @Test
    public void delayElement() {
        Mono.just(1)
                .map(value -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(Schedulers.isInNonBlockingThread());
                    return Mono.fromFuture(CompletableFuture.supplyAsync(() -> {
                        try {
                            System.out.println(Thread.currentThread().getName());
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return value;
                    })).block();
                })
                .delayElement(Duration.ofMillis(100))
                .block();
    }

    @Test
    public void elapsed() {
        Mono.fromFuture(CompletableFuture.supplyAsync(() -> 10))
                .elapsed()
                .map(value -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(Schedulers.isInNonBlockingThread());
                    return Mono.fromFuture(CompletableFuture.supplyAsync(() -> {
                        try {
                            System.out.println(Thread.currentThread().getName());
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return value;
                    })).block();
                })
                .block();
    }

    @Test
    public void take() {
        Mono.just(1)
                .take(Duration.ofMillis(100))
                .map(value -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(Schedulers.isInNonBlockingThread());
                    return Mono.fromFuture(CompletableFuture.supplyAsync(() -> {
                        try {
                            System.out.println(Thread.currentThread().getName());
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return value;
                    })).block();
                })
                .block();
    }

    @Test
    public void timestamp() {
        Mono.fromFuture(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        }))
                .timestamp()
                .map(value -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(Schedulers.isInNonBlockingThread());
                    return Mono.fromFuture(CompletableFuture.supplyAsync(() -> {
                        try {
                            System.out.println(Thread.currentThread().getName());
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return value;
                    })).block();
                })
                .block();
    }

    @Test
    public void parallel() throws InterruptedException {
        Flux.just(10, 12, 13)
                .parallel()
                .runOn(Schedulers.parallel())
                .map(value -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(Schedulers.isInNonBlockingThread());
                    return Mono.fromFuture(CompletableFuture.supplyAsync(() -> {
                        try {
                            System.out.println(Thread.currentThread().getName());
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return value;
                    })).block();
                })
                .doOnError(Throwable::printStackTrace)
                .subscribe(System.out::println);

        Thread.sleep(2000);
    }

    @Test
    public void delaySubscription() {
        Flux.just(1, 2, 3)
                .window(Duration.ofMillis(100))
                .blockFirst()
                .map(value -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(Schedulers.isInNonBlockingThread());
                    return Mono.fromFuture(CompletableFuture.supplyAsync(() -> {
                        try {
                            System.out.println(Thread.currentThread().getName());
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return value;
                    })).block();
                })
                .blockLast();
    }

    @Test
    public void delaySequence() {
        Flux.just(1, 2, 3)
                .delaySequence(Duration.ofMillis(100))
                .map(value -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(Schedulers.isInNonBlockingThread());
                    return Mono.fromFuture(CompletableFuture.supplyAsync(() -> {
                        try {
                            System.out.println(Thread.currentThread().getName());
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return value;
                    })).block();
                })
                .blockLast();
    }

    @Test
    public void kekkek() {
        Flux<Integer> f = Flux.just(1, 2, 3);
        f = f.publishOn(Schedulers.single());

        if (new Random().nextBoolean()) {
            f = f.publishOn(Schedulers.immediate());
        } else {
            f = f.subscribeOn(Schedulers.elastic());
        }

        f.map(i -> Mono.fromFuture(CompletableFuture.completedFuture(1)).block()).blockLast();
    }
}
