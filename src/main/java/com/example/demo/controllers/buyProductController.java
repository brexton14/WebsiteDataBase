package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@Controller
public class buyProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/buyProduct")
    public String buyProduct(@RequestParam ("productID")Long theId, Model theModel) {
        Optional<Product> theProduct = productRepository.findById(theId);

        if (theProduct.isPresent()) {
            Product product = theProduct.get();

            if(product.getInv() > 0){
                product.setInv(product.getInv() - 1);
                productRepository.save(product);
                return"/buysuccess";
            }else{
                return "/buyfail";
            }
        }else{
            return"/buyfail";
        }
    }
}
