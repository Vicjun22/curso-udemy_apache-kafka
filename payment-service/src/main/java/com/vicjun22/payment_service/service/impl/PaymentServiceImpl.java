package com.vicjun22.payment_service.service.impl;

import com.vicjun22.payment_service.model.Payment;
import com.vicjun22.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@RequiredArgsConstructor
@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("Pagamento recebido {}", payment);
        Thread.sleep(1000);

        log.info("Enviando pagamento...");
        kafkaTemplate.send("payment-topic", payment);
    }
}
