package pl.javastart.verificationofmethodparameters;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class MyClassTest {

    @Test
    public void verifyExample() {
        MyClass myClass = mock(MyClass.class);

        myClass.myMethod();

//        verify(myClass, times(2)).myMethod();
//        verify(myClass, atLeast(2)).myMethod();
    }

}