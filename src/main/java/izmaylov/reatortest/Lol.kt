@file:JvmMultifileClass
@file:JvmName("LolUtil")

package izmaylov.reatortest

import izmaylov.reatortest.SomeService.useNonBlocking
import org.reactivestreams.Processor
import org.reactivestreams.Publisher
import org.springframework.stereotype.Service
import reactor.core.publisher.DirectProcessor
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import reactor.core.publisher.toFlux
import reactor.core.scheduler.Schedulers
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors
import java.util.concurrent.ThreadLocalRandom
import java.util.function.BiFunction
import java.util.function.Supplier
import java.util.stream.Stream
import kotlin.random.Random

fun fromKotlin(): Flux<Int> =
        Flux.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
                .map { it + 2 }
                .filter { it > 2 }

@Service
class Lol {
    val c: String? = null

    fun bob(): Flux<Int>? = null

    fun a() = Flux.just(1)
            .map(fun (_: Int) = null)
            .flatMap<String> { null }
            .map {
                println(it)

                if ("a" in it)
                    return@map null as Double?

                val aaaa = null ?: return@map null

                null
            }
            .flatMap {
                println("kek")
                bob()
            }

    fun b(d: Int?) = Flux.create<Int> {
        it.next(null)
    }.map { c }
            .map {
                if (d != null) {
                    return@map null
                } else {
                    1
                }
            }

    fun kek() {
        fun flux() = Flux.fromArray(arrayOf(1, 2, 3)).map { it * 2 }
    }

    fun lol() {
        val proc: Processor<Int, Int> = DirectProcessor.create()
        proc.onNext(null)
    }

    fun aaaaa() = Flux.just(1, 2, 3)
            .handle<Int> { i, sink ->
                if (i < 3)
                    sink.next(10)
            }

    val a: String? = if (Random.nextBoolean()) null else "a"

    fun aaa() {
        Flux.just(10).map {
            println(it)
            a
        }
                .map { it + 1 }
                .map { it + 1 }
                .map { it + 1 }
                .map { it + 1 }
        

        fun s(ss: String) = println(ss)

        val bbbb = Flux.just(10).map {
            if (a != null) {
                return@map a
            } else {
                return@map a ?: 0
            }
        }.map {

        }

        1.toMono().map { it }
    }
}

object MyIterable : Iterable<Int> {
    var begin = 0

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            var iterations = 0
            override fun hasNext() = iterations != 5

            override fun next() = (begin++).apply { iterations++ }
        }
    }

}

val nullable = if (ThreadLocalRandom.current().nextBoolean()) null else "a"
fun a() {
    Flux.just(1, 2, 3)
            .map {
                if (nullable != null)
                    return@map nullable
                else 10
            }
}

fun AA() {
    val streamFlux = Flux.fromStream(IntRange(1, 1000).toList().stream())
            .publish()


    streamFlux.subscribe { println(it) }
    streamFlux.subscribe { println(it + 1000) }

    streamFlux.connect()

//    val streamFlux = Flux.fromStream { listOf(1, 2, 3).stream() }

    val arrayFlux = Flux.fromArray(arrayOf(1, 2, 3, 4, 5))

    if (10 > 20) {
        val arrayFlux = Flux.fromArray(arrayOf(1, 2, 3, 4, 5))
        arrayFlux.blockLast()
    } else {
        val arrayFlux = Flux.fromArray(arrayOf(1)).also { flux -> flux.map { it + 2 } }
    }

    arrayFlux.blockLast()

    val iterableFlux = Flux.fromIterable(MyIterable)

    val flux = Flux.just(1, 2, 3)
//            .mergeWith(streamFlux)
//            .zipWith(streamFlux)
//            .zipWith(streamFlux, BiFunction<Int, Int, Int> { t, u -> t + u })
//            .flatMap { Flux.from(streamFlux) }
//            .zipWith(arrayFlux)
            .zipWith(iterableFlux)

    flux.subscribe { println(it) }
    flux.subscribe { println(it + 10) }
    flux.blockLast()

    val callableMono = Mono.fromCallable {
        println("kek")
        10
    }

    callableMono.subscribe { println(it) }
    callableMono.subscribe { println(it) }

    callableMono.block()

    val executor = Executors.newFixedThreadPool(4)

//    val futureMono = Mono.fromFuture {
////        CompletableFuture.supplyAsync(Supplier<Int> {
////                    println("async")
////            10
////        }, executor)
////    }

    val futureMono = Mono.fromFuture(CompletableFuture.supplyAsync(Supplier<Int> {
        println("async")
        10
    }, executor))

    futureMono.subscribe { println(it) }
    futureMono.subscribe { println(it) }

    futureMono.block()

    val kekx = Flux.just(1L, 2L, 3L)
            .flatMap { Flux.fromStream(Stream.iterate(1) { i -> i + 1 }.limit(it)) }

    kekx.subscribe { println(it) }
    kekx.subscribe { println(it + 10) }
    kekx.subscribe { println(it + 100) }

    listOf(1).toFlux()
            .filter { it > 1}
            .filter { it > 1}
            .filter { it > 1}
            .filter { it > 1}
            .filter { it > 1}

    kekx.blockLast()

    println("vse")

    if ((true) && (false)) {
        return
    }

    var f = Flux.just(1)

    run {
        f = Flux.just(2)
    }

    f.lol()

    var ff = Flux.just(1)

    for (i in 1..20) {
        ff = Flux.just(20)

        val ff = Flux.just(12)
    }

    ff.subscribe()

    1.toMono()
    Mono.just(1).subscribe()

    Flux.just(1, 2, 3).publishOn(Schedulers.parallel())
            .map {
                Mono.just(1).block()
            }
            .subscribe()

    val a = Flux.just(1, 2, 3).takeIf { Random.nextBoolean() }
    val c = Mono.just(1).`as` { null as? Int }
}

fun Any.lol() = println(this)

//val a: String? = null
//
//fun a(b: Int?) {
//    reactor.core.publisher.Flux.just(10)
//            .map {a }
//}
//
//object B {
//    val lol: String? = null
//}

fun usedAsArrayElement() {
    val a = arrayOfNulls<Publisher<*>>(10)
    a[0] = Mono.just(1)
}

private fun passNonBlocking() {
    val m = Mono.delay(Duration.ofMillis(100))
            .map { 10 }
    useNonBlocking(m)
}