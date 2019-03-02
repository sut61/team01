package com.example.demo.controller;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StockController {
    @Autowired
    StockRepository stockRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    AmountRepository amountRepository;
    @Autowired
    UnitRepository unitRepository;


    @GetMapping(path = "/stock")
    private Collection<Stock> getStock(){
        return this.stockRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "/stock/{product}/{amount}/{unit}/{priceperitem}/{totalprice}/{date}/{note}")
    public Stock stock(@PathVariable Long product, @PathVariable Long amount, @PathVariable Long unit,
                       @PathVariable Double priceperitem, @PathVariable Double totalprice,
                       @PathVariable Date date, @PathVariable String note){



        Stock stock = new Stock();
        stock.setPriceperitem(priceperitem);
        stock.setTotalprice(totalprice);
        stock.setDate(date);
        stock.setNote(note);

        Product product1 = productRepository.findById(product).get();
        stock.setProduct(product1);

        Amount amount1 = amountRepository.findById(amount).get();
        stock.setAmount(amount1);

        Unit unit1 = unitRepository.findById(unit).get();
        stock.setUnit(unit1);

        stockRepository.save(stock);
        return stock;

    }
}
