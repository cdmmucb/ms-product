package com.example.msproduct.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@FeignClient("ms-dashboard")
public interface DashboardService {
    @RequestMapping("v1/dashboard/prendassinstock")
    public Integer getPrendasSinStock();

    @RequestMapping("v1/dashboard/prendasconstock")
    public Integer getPrendasConStock();

    @RequestMapping("v1/dashboard/prendasporcategoria")
    public List<Integer> getPrendasPorCategoria();

    @RequestMapping("v1/dashboard/prendasmes")
    public Integer getPrendasMes();

    @RequestMapping("v1/dashboard/ordenesmes")
    public Integer getOrdenesMes();

    @RequestMapping("v1/dashboard/montomes")
    public Float getMontoMes();

    @RequestMapping("v1/dashboard/cantidadprendasmes")
    public Integer getCantidadPrendasMes();
}
