package izmaylov.reatortest

import org.junit.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Hooks
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import java.time.Duration
import java.util.concurrent.CountDownLatch

class Bbbb {
    @Test
    fun `simple test`() {
        Hooks.onOperatorDebug()
        Flux.range(0, 5)
                .subscribeOn(Schedulers.parallel())
                .subscribeOn(Schedulers.single())
                //                .subscribeOn(Schedulers.elastic())
                //                .publishOn(Schedulers.elastic())
                .hide()
                .map { it + 2 }
                .handle<Int> { i, sink -> sink.next(i + 1) }
                .map { i ->
                    val latch = CountDownLatch(1)

                    Mono.delay(Duration.ofMillis((i!! * 100).toLong()))
                            .subscribe { latch.countDown() }

                    try {
                        latch.await()
                    } catch (e: InterruptedException) {
                        throw RuntimeException(e)
                    }

                    i
                }
                .blockLast()
    }
}