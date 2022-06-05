package com.example.msproduct.service;

import com.example.msproduct.dto.Purchase;
import com.example.msproduct.dto.PurchaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient("ms-checkout")
public interface CheckoutService {
    @RequestMapping("v1/checkout/purchase")
    public PurchaseResponse placeOrder(Purchase purchase);
}
