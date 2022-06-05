package com.example.msproduct.api;

import com.example.msproduct.dto.Purchase;
import com.example.msproduct.dto.PurchaseResponse;
import com.example.msproduct.service.CheckoutService;
import com.example.msproduct.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/product")
public class ProductController {
    private DashboardService dashboardService;
    private CheckoutService checkoutService;

    @Autowired
    private ProductController(DashboardService dashboardService, CheckoutService checkoutService){
        this.dashboardService=dashboardService;
        this.checkoutService=checkoutService;
    }

    @RequestMapping(value="/prendassinstock", method = RequestMethod.GET)
    public ResponseEntity<Integer> getPrendasSinStock(){
        Integer a = dashboardService.getPrendasSinStock();
        return new ResponseEntity<>(a, HttpStatus.OK);
    }
    @RequestMapping(value="/prendasconstock", method = RequestMethod.GET)
    public ResponseEntity<Integer> getPrendasConStock(){
        Integer a = dashboardService.getPrendasConStock();
        return new ResponseEntity<>(a, HttpStatus.OK);
    }
    @RequestMapping(value="/prendasporcategoria", method = RequestMethod.GET)
    public ResponseEntity<List<Integer>> getPrendasPorCategoria(){
        List<Integer> a = dashboardService.getPrendasPorCategoria();
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @RequestMapping(value="/prendasmes", method = RequestMethod.GET)
    public ResponseEntity<Integer> getPrendasMes(){
        Integer a = dashboardService.getPrendasMes();
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @RequestMapping(value="/ordenesmes", method = RequestMethod.GET)
    public ResponseEntity<Integer> getOrdenesMes(){
        Integer a = dashboardService.getOrdenesMes();
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @RequestMapping(value="/montomes", method = RequestMethod.GET)
    public ResponseEntity<Float> getMontoMes(){
        Float a = dashboardService.getMontoMes();
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @RequestMapping(value="/cantidadprendasmes", method = RequestMethod.GET)
    public ResponseEntity<Integer> getCantidadPrendasMes(){
        Integer a = dashboardService.getCantidadPrendasMes();
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @RequestMapping(value="/purchase", method = RequestMethod.POST)
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        return purchaseResponse;
    }
}
