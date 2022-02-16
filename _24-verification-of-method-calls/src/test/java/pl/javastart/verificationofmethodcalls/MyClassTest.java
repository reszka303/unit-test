package pl.javastart.verificationofmethodcalls;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class MyClassTest {

    @Test
    public void verifyExample() {
        MyClass myClass = mock(MyClass.class);

        myClass.myMethod();

//        verify(myClass, times(2)).myMethod();
//        verify(myClass, atLeast(2)).myMethod();
    }

}