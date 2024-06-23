package com.vicjun22.payment_service.service;

import com.vicjun22.payment_service.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
