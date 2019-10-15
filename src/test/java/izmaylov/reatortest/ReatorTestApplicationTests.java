package izmaylov.reatortest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReatorTestApplicationTests {

    private static final Flux<String> FLUX = Flux.just("1", "2");

    public void incorrect() {
        StepVerifier.create(FLUX).verifyComplete();
        StepVerifier.create(FLUX).expectError().verify();
        StepVerifier.create(FLUX).expectNext("1").verifyComplete();
        FLUX.as(StepVerifier::create).verifyComplete();
        FLUX.as(StepVerifier::create).expectError().verify();
        FLUX.as(StepVerifier::create).expectNext("1").verifyComplete();
    }

    public void kek() {
        StepVerifier.create(FLUX).verifyComplete();
    }


    @Test
    public void contextLoads() {
        StepVerifier.create(Flux.empty()).expectError().verify();
    }



}
