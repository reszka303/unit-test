package pl.javastart.argumentcaptors;

import java.util.List;
import java.util.Random;

public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    void prepareAndSave(PaymentDto paymentDto) {
        //przetwarzanie
        Payment payment = new Payment();
        payment.setMethod(paymentDto.getMethod());  //PayPal
        payment.setCode(paymentDto.getMethod().toLowerCase() + "_" + new Random().nextInt()); //paypal_41412
        //zapis
        this.paymentRepository.save(payment);
    }

    void prepareAndSaveMultiple(List<PaymentDto> paymentDtos) {
        for (PaymentDto paymentDto : paymentDtos) {
            prepareAndSave(paymentDto);
        }
    }

}
