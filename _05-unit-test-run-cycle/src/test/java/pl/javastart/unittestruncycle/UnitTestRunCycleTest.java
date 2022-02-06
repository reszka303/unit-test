package pl.javastart.unittestruncycle;

import org.junit.jupiter.api.*;

import java.util.Random;

//Jedna instancja dla wszystkich testów
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)

//Tworzenie nowej instancji dla kazdego testu
//domyślne ustawienie ↓
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class UnitTestRunCycleTest {

    private int counterWithAnnotationsJUnit;
    private int counterNoAnnotations;
    private Random random;

    @BeforeEach
    public void beforeEach() {
        random = new Random();
        System.out.println("beforeEach()");
        counterWithAnnotationsJUnit++;
        System.out.println("Counter z adnotacjami: " + counterWithAnnotationsJUnit);

        System.out.println("----------------");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("beforeAll()");
        System.out.println("----------------");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("afterEach()");
        counterWithAnnotationsJUnit++;
        System.out.println("Counter z adnotacjami: " + counterWithAnnotationsJUnit);
        System.out.println("----------------");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll()");
        System.out.println("----------------");
    }

    @Test
    public void test1() {
        counterWithAnnotationsJUnit++;
        counterNoAnnotations++;
        System.out.println("test1 Counter z adnotacjami: " + counterWithAnnotationsJUnit);
        System.out.println("Counter bez adnotacji: " + counterNoAnnotations);
        System.out.println("Random to: " + random.nextInt());
        System.out.println("test1 Hash: " + this);
        System.out.println("----------------");
    }

    @Test
    public void test2() {
        counterWithAnnotationsJUnit++;
        counterNoAnnotations++;
        System.out.println("test2 Counter z adnotacjami: " + counterWithAnnotationsJUnit);
        System.out.println("Counter bez adnotacji: " + counterNoAnnotations);
        System.out.println("Random to: " + random.nextInt());
        System.out.println("test2 Hash:" + this);
        System.out.println("----------------");
    }

}