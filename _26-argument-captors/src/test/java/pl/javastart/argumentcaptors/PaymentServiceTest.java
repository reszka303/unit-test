package pl.javastart.argumentcaptors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;
    @Mock
    private PaymentDto paymentDto;
    @Captor
    private ArgumentCaptor<Payment> captor;

    private PaymentService paymentService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        // given
        paymentService = new PaymentService(paymentRepository);

        paymentDto = mock(PaymentDto.class);
        when(paymentDto.getMethod()).thenReturn("PayPal");
    }

    @Test
    public void shouldSetCorrectPaymentPrefix() {
        // given

// Poniższy sposób jest odradzany, ponieważ gdy dodamy jakiś nowy argument do obiektu
// PaymentDto to wtedy trzeba będzie poprawiać testy o ten właśnie nowy argument
//        PaymentDto paymentDto = new PaymentDto();
//        paymentDto.setMethod("PayPal");


// Preferowany sposób testowania, nie ma wpływu na zmiany w klasie
//        PaymentDto mockPaymentDto = mock(PaymentDto.class);
//        when(mockPaymentDto.getMethod()).thenReturn("PayPal");

        // when
        paymentService.prepareAndSave(paymentDto);

        // then
        verify(paymentRepository).save(captor.capture());
        Payment payment = captor.getValue();

        assertThat(payment.getCode()).startsWith("paypal_");
    }

    @Test
    public void shouldSetCorrectPaymentMethod() {
        // given

        // when
        paymentService.prepareAndSave(paymentDto);

        // then
        verify(paymentRepository).save(captor.capture());

        Payment payment = captor.getValue();
        assertThat(payment.getMethod()).isEqualTo("PayPal");
    }

    @Test
    public void shouldSetCorrectPaymentPrefixMultiple() {
        // given
        PaymentDto paymentDto1 = mock(PaymentDto.class);
        PaymentDto paymentDto2 = mock(PaymentDto.class);
        PaymentDto paymentDto3 = mock(PaymentDto.class);
        when(paymentDto1.getMethod()).thenReturn("PayPal");
        when(paymentDto2.getMethod()).thenReturn("Przelewy24");
        when(paymentDto3.getMethod()).thenReturn("Przelewy24");
        List<PaymentDto> paymentDtos = Arrays.asList(paymentDto1, paymentDto2, paymentDto3);


        // when
        paymentService.prepareAndSaveMultiple(paymentDtos);

        // then
        verify(paymentRepository, times(3)).save(captor.capture());

        List<Payment> paymentList = captor.getAllValues();

        Payment payment1 = paymentList.get(0);
        assertThat(payment1.getCode()).startsWith("paypal_");

        Payment payment2 = paymentList.get(1);
        assertThat(payment2.getCode()).startsWith("przelewy24_");
    }

}