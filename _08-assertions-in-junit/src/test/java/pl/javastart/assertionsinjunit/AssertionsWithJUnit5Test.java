package pl.javastart.assertionsinjunit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AssertionsWithJUnit5Test {

    @Test
    public void exampleTest() {
        // given

        // when

        long start = System.currentTimeMillis();

        String expected = "a";
        String actual = "a";

        //then

//        Assertions.assertEquals(expected, actual);
//        Assertions.assertEquals(expected, actual, "Wartości różnią się od siebie");
//        Assertions.assertEquals(expected, actual, () -> "Wartości różnią się od siebie");


//        Nawet jeśli nie ma błędu to metoda createMessage() i tak się wykona ↓
//        Assertions.assertEquals(expected, actual, createMessage());
//        Metoda createMessage() w przypadku wyrażenia lambda lub referencji do metody
//        wykona się dopiero wtedy, gdy będzie błąd ↓
//        Assertions.assertEquals(expected, actual, () -> createMessage());
        Assertions.assertEquals(expected, actual, this::createMessage);
        System.out.println("Trwało to: " + (System.currentTimeMillis() - start) + " ms");

    }

    private String createMessage()  {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Wartości różnią się od siebie";
    }

    @Test
    public void assertionaOverview() {

        // given

        // when
        String result = null;
        String abc = "abc";
        boolean isTrue = true;
        boolean isFalse = false;

        int a;
        int same = 1;
        int notSame = 2;
        a = same;

        //then

        Assertions.assertNull(result);
        Assertions.assertNotNull(abc);

        Assertions.assertTrue(isTrue);
        Assertions.assertFalse(isFalse);

        Assertions.assertSame(same, a);
        Assertions.assertNotSame(notSame, a);
    }

}